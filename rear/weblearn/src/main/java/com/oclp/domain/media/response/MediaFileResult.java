package com.oclp.domain.media.response;

import com.oclp.common.model.response.ResponseResult;
import com.oclp.common.model.response.ResultCode;
import com.oclp.domain.media.MediaFile;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MediaFileResult extends ResponseResult {
    MediaFile mediaFile;
    public MediaFileResult(ResultCode resultCode, MediaFile mediaFile) {
        super(resultCode);
        this.mediaFile = mediaFile;
    }
}
