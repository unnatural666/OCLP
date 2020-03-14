package com.oclp.api.cms;

import com.oclp.domain.cms.CmsPage;
import com.oclp.domain.cms.request.QueryPageRequest;
import com.oclp.domain.cms.response.CmsPageResult;
import com.oclp.model.response.QueryResponseResult;

public interface CmsPageControllerApi {
    //页面查询
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);
    //新增页面
    public CmsPageResult add(CmsPage cmsPage);

}

