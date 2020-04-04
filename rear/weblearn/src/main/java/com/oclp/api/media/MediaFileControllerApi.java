package com.oclp.api.media;

import com.oclp.common.model.response.QueryResponseResult;
import com.oclp.domain.media.MediaFile;
import com.oclp.domain.media.request.QueryMediaFileRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "媒体文件管理",description = "媒体文件管理接口")
public interface MediaFileControllerApi {

    @ApiOperation("查询文件列表")
    public QueryResponseResult<MediaFile> findList(int page, int size, QueryMediaFileRequest queryMediaFileRequest) ;
}
