package com.green.org.demomapstruct.controller;

import com.green.org.demomapstruct.dto.CategoryResDto;
import com.green.org.demomapstruct.response.SuccessResponse;
import com.green.org.demomapstruct.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "category")
    public Map<String, Object> getController() {
        List<CategoryResDto> categories = categoryService.findAllCategory();

        return new SuccessResponse(categories).toJson();
    }

}
