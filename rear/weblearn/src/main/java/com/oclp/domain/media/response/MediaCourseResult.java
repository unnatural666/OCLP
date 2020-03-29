package com.oclp.domain.media.response;

import com.oclp.common.model.response.ResponseResult;
import com.oclp.common.model.response.ResultCode;
import com.oclp.domain.media.MediaFile;
import com.oclp.domain.media.MediaVideoCourse;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class MediaCourseResult extends ResponseResult {
    public MediaCourseResult(ResultCode resultCode, MediaVideoCourse mediaVideoCourse) {
        super(resultCode);
        this.mediaVideoCourse = mediaVideoCourse;
    }

    MediaFile mediaVideo;
    MediaVideoCourse mediaVideoCourse;
}
