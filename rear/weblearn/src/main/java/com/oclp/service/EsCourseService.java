package com.oclp.service;

import com.oclp.common.model.response.CommonCode;
import com.oclp.common.model.response.QueryResponseResult;
import com.oclp.common.model.response.QueryResult;
import com.oclp.domain.course.CoursePub;
import com.oclp.domain.course.TeachplanMedia;
import com.oclp.domain.course.TeachplanMediaPub;
import com.oclp.domain.search.CourseSearchParam;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EsCourseService {

    @Value("${weblearn.elasticsearch.course.index}")
    private String index;
    @Value("${weblearn.elasticsearch.media.index}")
    private String media_index;
    @Value("${weblearn.elasticsearch.course.type}")
    private String type;
    @Value("${weblearn.elasticsearch.media.type}")
    private String media_type;
    @Value("${weblearn.elasticsearch.course.source_field}")
    private String source_field;
    @Value("${weblearn.elasticsearch.media.source_field}")
    private String media_source_field;

    @Autowired
    RestHighLevelClient restHighLevelClient;

    //课程搜索
    public QueryResponseResult<CoursePub> list(int page, int size, CourseSearchParam courseSearchParam) {

        //创建搜索请求对象
        SearchRequest searchRequest=new SearchRequest(index);
        //设置搜索类型
        searchRequest.types(type);
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        //过滤原字段
        String[] source_field_array=source_field.split(",");
        searchSourceBuilder.fetchSource(source_field_array,new String[]{});
        //创建布尔查询对象
        BoolQueryBuilder boolQueryBuilder=QueryBuilders.boolQuery();
        //搜索条件
        //根据关键字搜索
        if(StringUtils.isNotEmpty(courseSearchParam.getKeyword())){
            //匹配关键字
            MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(courseSearchParam.getKeyword(), "name", "teachplan","description");
            //设置匹配占比
            multiMatchQueryBuilder.minimumShouldMatch("70%");
            //提升另个字段的Boost值
            multiMatchQueryBuilder.field("name",10);
            boolQueryBuilder.must(multiMatchQueryBuilder);
        }
        if (StringUtils.isNotEmpty(courseSearchParam.getMt())){
            //根据一级分类搜索
            boolQueryBuilder.filter(QueryBuilders.termQuery("mt",courseSearchParam.getMt()));
        }
        if (StringUtils.isNotEmpty(courseSearchParam.getSt())){
            //根据二级分类搜索
            boolQueryBuilder.filter(QueryBuilders.termQuery("st",courseSearchParam.getSt()));
        }
        if (StringUtils.isNotEmpty(courseSearchParam.getGrade())){
            //根据难度等级
            boolQueryBuilder.filter(QueryBuilders.termQuery("grade",courseSearchParam.getGrade()));
        }
        //分页
        if(page<=0){
            page = 1;
        }
        if(size<=0){
            size = 12;
        }
        int start = (page-1)*size;
        searchSourceBuilder.from(start);
        searchSourceBuilder.size(size);
        //设置高亮显示
        HighlightBuilder highlightBuilder=new HighlightBuilder();
        highlightBuilder.preTags("<font class='eslight'>");
        highlightBuilder.postTags("</font>");
        //设置高亮字段
        highlightBuilder.fields().add(new HighlightBuilder.Field("name"));
        searchSourceBuilder.highlighter(highlightBuilder);
        searchSourceBuilder.query(boolQueryBuilder);
        searchRequest.source(searchSourceBuilder);

        QueryResult<CoursePub> queryResult=new QueryResult();
        List<CoursePub> list=new ArrayList<>();
        try {
            //执行搜索
            SearchResponse searchResponse= restHighLevelClient.search(searchRequest);
            //获取响应结果
            SearchHits hits = searchResponse.getHits();
            //记录总数
            long totalHits = hits.getTotalHits();
            queryResult.setTotal(totalHits);
            SearchHit[] searchHits = hits.getHits();
            for (SearchHit hit:searchHits){
                CoursePub coursePub = new CoursePub();
                //取出source
                Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                //取出id
                String id = (String) sourceAsMap.get("id");
                coursePub.setId(id);
                //取出name
                String name = (String) sourceAsMap.get("name");
                Map<String, HighlightField> highlightFields = hit.getHighlightFields();
                if(highlightFields.get("name")!=null){
                    HighlightField name1 = highlightFields.get("name");
                    if (name1!=null){
                    Text[] fragments = name1.fragments();
                        StringBuffer stringBuffer = new StringBuffer();
                        for(Text text:fragments){
                            stringBuffer.append(text);
                        }
                        name = stringBuffer.toString();
                    }
                }
                coursePub.setName(name);
                //图片
                String pic = (String) sourceAsMap.get("pic");
                coursePub.setPic(pic);
                //价格
                Double price = null;
                try {
                    if(sourceAsMap.get("price")!=null ){
                        price = (Double) sourceAsMap.get("price");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                coursePub.setPrice(price);
                //旧价格
                Double price_old = null;
                try {
                    if(sourceAsMap.get("price_old")!=null ){
                        price_old = (Double) sourceAsMap.get("price_old");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                coursePub.setPrice_old(price_old);
                //将coursePub对象放入list
                list.add(coursePub);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        queryResult.setList(list);
        QueryResponseResult<CoursePub> queryResponseResult=new QueryResponseResult<CoursePub>(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }

    //根据id从搜索索引中查出信息
    public Map<String, CoursePub> getall(String id) {

        //定义一个搜索请求对象
        SearchRequest searchRequest = new SearchRequest(index);
        //指定type
        searchRequest.types(type);
        //定义SearchSourceBuilder
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        //设置使用termQuery
        searchSourceBuilder.query(QueryBuilders.termQuery("id",id));
        searchRequest.source(searchSourceBuilder);
        //最终返回的课程信息
        CoursePub coursePub = new CoursePub();
        Map<String,CoursePub> map = new HashMap<>();
        try {
            SearchResponse response=restHighLevelClient.search(searchRequest);
            SearchHits hits=response.getHits();
            SearchHit[] searchHits=hits.getHits();
            for (SearchHit hit:searchHits){
                //获取源文档内容
                Map<String,Object> sourceAsMap=hit.getSourceAsMap();
                String courseId = (String) sourceAsMap.get("id");
                coursePub.setId(courseId);
                String name = (String) sourceAsMap.get("name");
                coursePub.setName(name);
                String grade = (String) sourceAsMap.get("grade");
                coursePub.setGrade(grade);
                String charge = (String) sourceAsMap.get("charge");
                coursePub.setPic(charge);
                String pic = (String) sourceAsMap.get("pic");
                coursePub.setPic(pic);
                String description = (String) sourceAsMap.get("description");
                coursePub.setDescription(description);
                String teachplan = (String) sourceAsMap.get("teachplan");
                coursePub.setTeachplan(teachplan);

                map.put(courseId,coursePub);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    //根据多个课程计划id查询视频信息
    public QueryResponseResult<TeachplanMediaPub> getmedia(String[] teachplanIds) {
        //定义一个搜索请求对象
        SearchRequest searchRequest = new SearchRequest(media_index);
        //指定type
        searchRequest.types(media_type);
        //定义SearchSourceBuilder
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        //设置使用termsQuery根据多个id查询视频信息
        searchSourceBuilder.query(QueryBuilders.termsQuery("teachplan_id",teachplanIds));
        //过滤源字段
        String[] split=media_source_field.split(",");
        searchSourceBuilder.fetchSource(split,new String[]{});
        searchRequest.source(searchSourceBuilder);
        List<TeachplanMediaPub> teachplanMediaPubList=new ArrayList<>();
        long total=0;
        try {
            //执行搜索
            SearchResponse search=restHighLevelClient.search(searchRequest);
            SearchHits hits=search.getHits();
            total=hits.totalHits;
            SearchHit[] searchHits=hits.getHits();
            for (SearchHit hit:searchHits){
                TeachplanMediaPub teachplanMediaPub=new TeachplanMediaPub();
                Map<String,Object> sourceAsMap=hit.getSourceAsMap();
                //取出课程计划媒资信息
                String courseid = (String) sourceAsMap.get("courseid");
                String media_id = (String) sourceAsMap.get("media_id");
                String media_url = (String) sourceAsMap.get("media_url");
                String teachplan_id = (String) sourceAsMap.get("teachplan_id");
                String media_fileoriginalname = (String) sourceAsMap.get("media_fileoriginalname");
                teachplanMediaPub.setCourseId(courseid);
                teachplanMediaPub.setMediaUrl(media_url);
                teachplanMediaPub.setMediaFileOriginalName(media_fileoriginalname);
                teachplanMediaPub.setMediaId(media_id);
                teachplanMediaPub.setTeachplanId(teachplan_id);
                //将数据加入列表
                teachplanMediaPubList.add(teachplanMediaPub);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //构建返回课程媒资信息对象
        QueryResult<TeachplanMediaPub> queryResult = new QueryResult<>();
        queryResult.setList(teachplanMediaPubList);
        queryResult.setTotal(total);
        QueryResponseResult<TeachplanMediaPub> queryResponseResult=new QueryResponseResult<TeachplanMediaPub>(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;

    }
}
