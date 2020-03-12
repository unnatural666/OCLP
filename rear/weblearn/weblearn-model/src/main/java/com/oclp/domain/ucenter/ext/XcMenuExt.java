package com.oclp.domain.ucenter.ext;

import com.oclp.domain.course.ext.CategoryNode;
import com.oclp.domain.ucenter.XcMenu;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by admin on 2018/3/20.
 */
@Data
@ToString
public class XcMenuExt extends XcMenu {

    List<CategoryNode> children;
}
