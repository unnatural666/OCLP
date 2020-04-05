package com.oclp.controller;

import com.oclp.api.search.EsCourseControllerApi;
import com.oclp.common.model.response.QueryResponseResult;
import com.oclp.common.model.response.QueryResult;
import com.oclp.domain.course.CoursePub;
import com.oclp.domain.course.TeachplanMediaPub;
import com.oclp.domain.search.CourseSearchParam;
import com.oclp.service.EsCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/search/course")
public class EsCourseController implements EsCourseControllerApi {
    @Autowired
    EsCourseService esCourseService;

    @Override
    @GetMapping(value="/list/{page}/{size}")
    public QueryResponseResult<CoursePub> list(@PathVariable("page") int page,@PathVariable("size") int size, CourseSearchParam courseSearchParam) {
        return esCourseService.list(page,size,courseSearchParam);
    }

    @Override
    @GetMapping("/getall/{id}")
    public Map<String, CoursePub> getall(@PathVariable("id") String id) {
        return esCourseService.getall(id);
    }

    @Override
    @GetMapping(value="/getmedia/{teachplanId}")
    public TeachplanMediaPub getmedia(@PathVariable("teachplanId") String teachplanId) {
        String[] teachplanIds = new String[]{teachplanId};
        //通过service查询ES获取课程媒资信息
        QueryResponseResult<TeachplanMediaPub> mediaPubQueryResponseResult = esCourseService.getmedia(teachplanIds);
        QueryResult<TeachplanMediaPub> queryResult = mediaPubQueryResponseResult.getQueryResult();
        if(queryResult!=null && queryResult.getList()!=null && queryResult.getList().size()>0) {
            //返回课程计划对应课程媒资
            return queryResult.getList().get(0);
        }
        return new TeachplanMediaPub();
    }
}
