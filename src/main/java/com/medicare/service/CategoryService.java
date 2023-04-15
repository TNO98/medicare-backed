package com.medicare.service;

import com.medicare.payload.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto findById(long id);
    List<CategoryDto> findAll();
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(Long id, CategoryDto categoryDto);
    void deleteCategory(long id);

}
