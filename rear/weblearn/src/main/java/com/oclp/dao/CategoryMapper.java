package com.oclp.dao;

import com.oclp.domain.course.ext.CategoryNode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CategoryMapper {
    //查询分类
    public CategoryNode selectList();
}
