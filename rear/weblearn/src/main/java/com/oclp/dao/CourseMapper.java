package com.oclp.dao;

import com.oclp.domain.course.CourseBase;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseMapper {

    CourseBase findCourseBaseById(String id);
}
