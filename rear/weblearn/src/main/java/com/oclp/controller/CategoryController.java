package com.oclp.controller;

import com.oclp.api.course.CategoryControllerApi;
import com.oclp.domain.course.ext.CategoryNode;
import com.oclp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController implements CategoryControllerApi {

    @Autowired
    CategoryService categoryService;

    @Override
    @GetMapping("list")
    public CategoryNode findList() {
        return categoryService.findList();
    }
}
