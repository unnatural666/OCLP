package com.oclp.service;

import com.oclp.dao.CategoryMapper;
import com.oclp.domain.course.ext.CategoryNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    //查询分类
    public CategoryNode findList(){
        return categoryMapper.selectList();
    }
}
