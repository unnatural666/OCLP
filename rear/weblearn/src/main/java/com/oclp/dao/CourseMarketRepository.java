package com.oclp.dao;

import com.oclp.domain.course.CourseMarket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMarketRepository extends JpaRepository<CourseMarket,String> {
}
