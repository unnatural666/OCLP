package com.oclp.api.search;

import com.oclp.common.model.response.QueryResponseResult;
import com.oclp.domain.course.CoursePub;
import com.oclp.domain.search.CourseSearchParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "课程搜索",description = "课程搜索")
public interface EsCourseControllerApi {

    //搜索课程信息
    @ApiOperation("课程搜索")
    public QueryResponseResult<CoursePub> list(int page, int size, CourseSearchParam courseSearchParam);
}
