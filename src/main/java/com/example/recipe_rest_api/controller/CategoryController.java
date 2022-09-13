package com.example.recipe_rest_api.controller;

import com.example.recipe_rest_api.entity.RecipeCategory;
import com.example.recipe_rest_api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<RecipeCategory> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/category")
    public boolean saveCategory(@RequestBody RecipeCategory recipeCategory) {
      return categoryService.saveCategory(recipeCategory);
    }
}
