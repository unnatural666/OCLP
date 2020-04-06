package com.oclp.api.learning;

import com.oclp.domain.learning.response.GetMediaResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "视频课程学习管理",description = "视频课程学习管理")
public interface CourseLearningControllerApi {

    @ApiOperation("获取课程学习地址")
    public GetMediaResult getmedia(String courseId, String teachplanId);
}
