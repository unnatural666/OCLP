package com.oclp.domain.learning.response;

import com.oclp.common.model.response.ResponseResult;
import com.oclp.common.model.response.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class GetMediaResult extends ResponseResult {

    //媒资文件播放地址
    String fileUrl;
    public GetMediaResult(ResultCode resultCode, String fileUrl) {
        super(resultCode);
        this.fileUrl = fileUrl;
    }
}
