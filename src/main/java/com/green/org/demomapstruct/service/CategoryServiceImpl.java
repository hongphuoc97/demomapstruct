package com.green.org.demomapstruct.service;

import com.green.org.demomapstruct.dto.CategoryResDto;
import com.green.org.demomapstruct.entity.Category;
import com.green.org.demomapstruct.mapper.CategoryMapper;
import com.green.org.demomapstruct.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryResDto> findAllCategory() {
        return categoryRepository.findAll().stream().
                map(categoryMapper::categoryToCategoryDto).collect(Collectors.toList());
    }

    @Override
    public void addCategory(Category entity) {
        // implements later.
    }

    @Override
    public void updateCategory(Category entity) {
        // implements later.
    }

    @Override
    public void deteteCategory(Integer id) {
        // implements later.
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return Optional.empty();
    }

}