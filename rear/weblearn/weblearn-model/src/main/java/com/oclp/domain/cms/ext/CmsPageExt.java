package com.oclp.domain.cms.ext;

import com.oclp.domain.cms.CmsPage;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class CmsPageExt extends CmsPage {
    private String htmlValue;

}
