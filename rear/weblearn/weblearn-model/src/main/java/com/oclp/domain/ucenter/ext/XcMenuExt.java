package com.oclp.domain.ucenter.ext;

import com.oclp.domain.course.ext.CategoryNode;
import com.oclp.domain.ucenter.XcMenu;
import lombok.Data;
import lombok.ToString;

import java.util.List;


@Data
@ToString
public class XcMenuExt extends XcMenu {

    List<CategoryNode> children;
}
