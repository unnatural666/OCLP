package com.oclp.domain.course.ext;

import com.oclp.domain.course.CourseBase;
import com.oclp.domain.course.CourseMarket;
import com.oclp.domain.course.CoursePic;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
public class CourseView implements Serializable {
    private CourseBase courseBase;//基础信息
    private CourseMarket courseMarket;//课程营销
    private CoursePic coursePic;//课程图片
    private TeachplanNode TeachplanNode;//教学计划
}
