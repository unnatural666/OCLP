package com.oclp.service;

import com.oclp.common.exception.ExceptionCast;
import com.oclp.common.model.response.CommonCode;
import com.oclp.controller.EsCourseController;
import com.oclp.domain.course.TeachplanMediaPub;
import com.oclp.domain.learning.response.GetMediaResult;
import com.oclp.domain.learning.response.LearningCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearningService {

    @Autowired
    EsCourseController esCourseController;

    //获取课程学习地址（视频播放地址）
    public GetMediaResult getmedia(String courseId, String teachplanId) {
        //校验学生的学习权限。。是否资费等
        //调用搜索接口查询
        TeachplanMediaPub teachplanMediaPub = esCourseController.getmedia(teachplanId);
        if(teachplanMediaPub == null || StringUtils.isEmpty(teachplanMediaPub.getMediaUrl())){
            //获取视频播放地址出错
            ExceptionCast.cast(LearningCode.LEARNING_GETMEDIA_ERROR);
        }
        return new GetMediaResult(CommonCode.SUCCESS,teachplanMediaPub.getMediaUrl());
    }
}
