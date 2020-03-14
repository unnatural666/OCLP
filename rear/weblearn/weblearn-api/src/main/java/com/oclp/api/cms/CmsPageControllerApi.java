package com.oclp.api.cms;

import com.oclp.domain.cms.CmsPage;
import com.oclp.domain.cms.request.QueryPageRequest;
import com.oclp.domain.cms.response.CmsPageResult;
import com.oclp.model.response.QueryResponseResult;
import com.oclp.model.response.ResponseResult;

public interface CmsPageControllerApi {
    //页面查询
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);
    //新增页面
    public CmsPageResult add(CmsPage cmsPage);
    //根据页面id查询页面信息
    public CmsPage findById(String id);
    //修改页面
    public CmsPageResult edit(String id,CmsPage cmsPage);
    //删除页面(根据id)
    public ResponseResult delete(String id);

}

