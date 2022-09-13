package com.example.recipe_rest_api.service;

import com.example.recipe_rest_api.db.CategoryRepository;
import com.example.recipe_rest_api.entity.RecipeCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoryService {

    static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<RecipeCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    public boolean saveCategory(RecipeCategory recipeCategory) {
        logger.error(recipeCategory.getName());

        categoryRepository.save(recipeCategory);
        return true;
    }
}
