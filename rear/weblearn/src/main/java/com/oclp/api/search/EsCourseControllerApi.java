package com.oclp.api.search;

import com.oclp.common.model.response.QueryResponseResult;
import com.oclp.domain.course.CoursePub;
import com.oclp.domain.course.TeachplanMediaPub;
import com.oclp.domain.search.CourseSearchParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

@Api(value = "课程搜索",description = "课程搜索")
public interface EsCourseControllerApi {

    //搜索课程信息
    @ApiOperation("课程搜索")
    public QueryResponseResult<CoursePub> list(int page, int size, CourseSearchParam courseSearchParam);

    @ApiOperation("根据课程id查询课程信息")
    public Map<String,CoursePub> getall(String id);

    @ApiOperation("根据课程计划id查询视频信息")
    public TeachplanMediaPub getmedia(String teachplanId);
}
