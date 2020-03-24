package com.oclp.domain.course.response;

import com.oclp.common.model.response.ResponseResult;
import com.oclp.common.model.response.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class CoursePublishResult extends ResponseResult {
    //String previewUrl;
    public CoursePublishResult(ResultCode resultCode/*, String previewUrl*/) {
        super(resultCode);
        //this.previewUrl = previewUrl;
    }
}