package com.oclp.api.cms;

import com.oclp.domain.cms.request.QueryPageRequest;
import com.oclp.model.response.QueryResponseResult;

public interface CmsPageControllerApi {
    //页面查询
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) ;
}

