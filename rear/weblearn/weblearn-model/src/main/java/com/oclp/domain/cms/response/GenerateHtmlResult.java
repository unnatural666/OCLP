package com.oclp.domain.cms.response;

import com.oclp.model.response.ResponseResult;
import com.oclp.model.response.ResultCode;
import lombok.Data;

@Data
public class GenerateHtmlResult extends ResponseResult {
    String html;
    public GenerateHtmlResult(ResultCode resultCode, String html) {
        super(resultCode);
        this.html = html;
    }
}
