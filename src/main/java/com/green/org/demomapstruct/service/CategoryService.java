package com.green.org.demomapstruct.service;

import com.green.org.demomapstruct.dto.CategoryResDto;
import com.green.org.demomapstruct.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryResDto> findAllCategory();

    void addCategory(Category entity);

    void updateCategory(Category entity);

    void deteteCategory(Integer id);

    Optional<Category> findById(Integer id);
}
