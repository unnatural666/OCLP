package com.oclp.api.course;

import com.oclp.common.model.response.QueryResponseResult;
import com.oclp.common.model.response.ResponseResult;
import com.oclp.domain.course.CourseBase;
import com.oclp.domain.course.Teachplan;
import com.oclp.domain.course.ext.CourseInfo;
import com.oclp.domain.course.ext.TeachplanNode;
import com.oclp.domain.course.request.CourseListRequest;
import com.oclp.domain.course.response.AddCourseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="课程管理接口",description = "课程管理接口，提供课程的增、删、改、查")
public interface CourseControllerApi {
    @ApiOperation("课程计划查询")
    public TeachplanNode findTeachplanList(String courseId);

    @ApiOperation("添加课程计划")
    public ResponseResult addTeachplan(Teachplan teachplan);

    @ApiOperation("查询我的课程列表")
    public QueryResponseResult<CourseInfo> findCourseList(int page, int size, CourseListRequest courseListRequest);

    @ApiOperation("添加课程基础信息")
    public AddCourseResult addCourseBase(CourseBase courseBase);
}
