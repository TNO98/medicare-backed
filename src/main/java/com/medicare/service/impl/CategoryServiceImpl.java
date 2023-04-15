package com.medicare.service.impl;

import com.medicare.entity.Category;
import com.medicare.exception.ResourceNotFoundException;
import com.medicare.payload.CategoryDto;
import com.medicare.repository.CategoryRepository;
import com.medicare.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public CategoryDto findById(long id) {
        return modelMapper.map(categoryRepository
                .findById(id).orElseThrow(()->new ResourceNotFoundException("category", "ID", id)),CategoryDto.class);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(category -> modelMapper.map(category,CategoryDto.class)).collect(Collectors.toList());
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        return modelMapper.map(categoryRepository.save(modelMapper.map(categoryDto, Category.class)),CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        Category category= categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Category","ID",+ id));
        categoryDto.setId(category.getId());
        category= categoryRepository.save(modelMapper.map(categoryDto,Category.class));
        return modelMapper.map(category,CategoryDto.class);
    }

    @Override
    public void deleteCategory(long id) {
        categoryRepository.deleteById(categoryRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Category","ID",+ id))
                .getId());
    }
}
