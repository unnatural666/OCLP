package com.oclp.dao;

import com.github.pagehelper.Page;
import com.oclp.domain.course.CourseBase;
import com.oclp.domain.course.ext.CourseInfo;
import com.oclp.domain.course.request.CourseListRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CourseMapper {

    CourseBase findCourseBaseById(String id);
    Page<CourseInfo> findCourseListPage(CourseListRequest courseListRequest);
}
