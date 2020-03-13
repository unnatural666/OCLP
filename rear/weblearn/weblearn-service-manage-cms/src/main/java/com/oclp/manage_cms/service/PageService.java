package com.oclp.manage_cms.service;

import com.oclp.domain.cms.CmsPage;
import com.oclp.domain.cms.request.QueryPageRequest;
import com.oclp.manage_cms.dao.CmsPageRepository;
import com.oclp.model.response.CommonCode;
import com.oclp.model.response.QueryResponseResult;
import com.oclp.model.response.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.xml.ws.Action;

@Service
public class PageService {
    @Autowired
    CmsPageRepository cmsPageRepository;

    //页面查询
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest){

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
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        QueryResult queryResult=new QueryResult();
        //QueryResult<CmsPage> cmsPageQueryResult = new QueryResult<CmsPage>();
        queryResult.setList(all.getContent());//数据列表
        queryResult.setTotal(all.getTotalElements());//数据总记录数
        //返回结果
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }
}
