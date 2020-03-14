package com.oclp.manage_cms.service;

import com.oclp.domain.cms.CmsPage;
import com.oclp.domain.cms.request.QueryPageRequest;
import com.oclp.domain.cms.response.CmsPageResult;
import com.oclp.manage_cms.dao.CmsPageRepository;
import com.oclp.model.response.CommonCode;
import com.oclp.model.response.QueryResponseResult;
import com.oclp.model.response.QueryResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
@Service
public class PageService {
    @Autowired
    CmsPageRepository cmsPageRepository;

    //页面查询
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest){

        if(queryPageRequest==null){
            queryPageRequest=new QueryPageRequest();
        }
        //自定义条件查询
        //定义条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        //条件值对象
        CmsPage cmsPage = new CmsPage();
        //设置条件值(站点id)
        if(StringUtils.isNotEmpty(queryPageRequest.getSiteId())){
            cmsPage.setSiteId(queryPageRequest.getSiteId());
        }
        //设置条件值(模板id)
        if(StringUtils.isNotEmpty(queryPageRequest.getTemplateId())){
            cmsPage.setTemplateId(queryPageRequest.getTemplateId());
        }
        //设置条件值(页面别名)
        if(StringUtils.isNotEmpty(queryPageRequest.getPageAliase())){
            cmsPage.setPageAliase(queryPageRequest.getPageAliase());
        }
        System.out.println(cmsPage);
        //创建条件实例
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        System.out.println(example);

        //分页参数
        if(page<=0){
            page=1;
        }
        page = page-1;//为了适应mongodb的接口将页码减1
        if(size<=0){
            size=10;
        }
        //分页对象
        Pageable pageable =PageRequest.of(page, size);
        //分页查询
        Page<CmsPage> all = cmsPageRepository.findAll(example,pageable);
        System.out.println(all);

        QueryResult queryResult=new QueryResult();
        queryResult.setList(all.getContent());//数据列表
        queryResult.setTotal(all.getTotalElements());//数据总记录数
        //返回结果
        QueryResponseResult queryResponseResult=new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }

    //新增页面
    public CmsPageResult add(CmsPage cmsPage){
        //校验页面名称、站点Id、页面webpath唯一
        CmsPage cmsPage1=cmsPageRepository.findByPageNameAndSiteIdAndPageWebPath(cmsPage.getPageName(),cmsPage.getSiteId(),cmsPage.getPageWebPath());
        if (cmsPage1==null){
            //调用dao新增页面
            cmsPage.setPageId(null);
            cmsPageRepository.save(cmsPage);
            return new CmsPageResult(CommonCode.SUCCESS,cmsPage);

        }
        //添加失败
        return new CmsPageResult(CommonCode.FAIL,null);


    }

}
