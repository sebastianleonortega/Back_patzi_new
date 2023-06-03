package com.platzi.Market_new.category.service;

import com.platzi.Market_new.category.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<CategoryDto> getAllCategory();
    Optional<CategoryDto> getCategoryId(Integer idCategory);
   CategoryDto updateCategory (Integer idCategory, CategoryDto categoryDto);
    CategoryDto saveCategory(CategoryDto categoryDto);
    Boolean existsCategoryByDescription (String description);

}
