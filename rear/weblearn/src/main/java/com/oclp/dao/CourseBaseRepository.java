package com.oclp.dao;

import com.oclp.domain.course.CourseBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseBaseRepository extends JpaRepository<CourseBase,String> {
}
