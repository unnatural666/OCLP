package com.oclp.domain.course.response;

import com.oclp.common.model.response.ResponseResult;
import com.oclp.common.model.response.ResultCode;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DeleteCourseResult extends ResponseResult {
    public DeleteCourseResult(ResultCode resultCode, String courseId) {
        super(resultCode);
        this.courseid = courseid;
    }
    private String courseid;

}
