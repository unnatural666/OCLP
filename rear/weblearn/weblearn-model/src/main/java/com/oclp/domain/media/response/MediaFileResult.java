package com.oclp.domain.media.response;

import com.oclp.domain.media.MediaFile;
import com.oclp.model.response.ResponseResult;
import com.oclp.model.response.ResultCode;
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
