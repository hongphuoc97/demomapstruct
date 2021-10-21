package com.green.org.demomapstruct.mapper;

import com.green.org.demomapstruct.dto.CategoryResDto;
import com.green.org.demomapstruct.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "id.id", target = "id")
    CategoryResDto categoryToCategoryDto(Category category);
}