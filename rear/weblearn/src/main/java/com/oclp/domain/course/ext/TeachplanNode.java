package com.oclp.domain.course.ext;

import com.oclp.domain.course.Teachplan;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class TeachplanNode extends Teachplan {

    List<TeachplanNode> children;
    //媒资信息
    String mediaId;
    String mediaFileoriginalname;

}