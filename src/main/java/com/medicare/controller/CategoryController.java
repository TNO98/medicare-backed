package com.medicare.controller;

import com.medicare.payload.ApiResponse;
import com.medicare.payload.CategoryDto;
import com.medicare.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
@CrossOrigin(origins ={"*"})
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(categoryDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable long id, @RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.updateCategory(id,categoryDto));
    }
    @DeleteMapping("/id")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable long id ){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(new ApiResponse("Category has been deleted successfully", true));
    }



}
