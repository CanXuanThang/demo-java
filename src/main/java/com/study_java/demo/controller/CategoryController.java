package com.study_java.demo.controller;

import com.study_java.demo.exceptions.AlreadyExistsException;
import com.study_java.demo.exceptions.ResourceNotFoundException;
import com.study_java.demo.models.Category;
import com.study_java.demo.response.ApiResponse;
import com.study_java.demo.service.category.CategoryService;
import com.study_java.demo.service.category.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/category")
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllCategories(){
        try {
            List<Category> categories = categoryService.getAllCategories();
            return ResponseEntity.ok(new ApiResponse("Found !", categories));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Error: ", INTERNAL_SERVER_ERROR));
        }
    }

    @PostMapping("/add")
    public  ResponseEntity<ApiResponse> addCategory(@RequestBody Category name){
        try {
            Category theCategory = categoryService.addCategory(name);
            return ResponseEntity.ok(new ApiResponse("Added !", theCategory));
        } catch (AlreadyExistsException e) {
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/categories/{id}/category")
    public  ResponseEntity<ApiResponse> getCategoryById(@PathVariable Long id) {
        try {
            Category theCategory = categoryService.getCategoryById(id);
            return  ResponseEntity.ok(new ApiResponse("Found !", theCategory));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/categories/{name}/category")
    public  ResponseEntity<ApiResponse> getCategoryByName(@PathVariable String name) {
        try {
            Category theCategory = categoryService.getCategoryByName(name);
            return  ResponseEntity.ok(new ApiResponse("Found !", theCategory));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/categories/{id}/delete")
    public  ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long id) {
        try {
            categoryService.deleteCategory(id);
            return  ResponseEntity.ok(new ApiResponse("Found !", null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/categories/{id}/update")
    public  ResponseEntity<ApiResponse> updateCategory(@PathVariable Long id, @RequestBody Category category){
        try {
            Category theCategory = categoryService.updateCategory(category, id);
            return ResponseEntity.ok(new ApiResponse("Updated !", theCategory));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }
}
