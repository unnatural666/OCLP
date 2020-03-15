package com.oclp.api.cms;

import com.oclp.domain.cms.CmsConfig;
import io.swagger.annotations.ApiOperation;

public interface CmsConfigControllerApi {
    @ApiOperation("根据id查询CMS配置信息")
    public CmsConfig getmodel(String id);
}
