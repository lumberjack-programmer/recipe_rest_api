package com.example.recipe_rest_api.service;

import com.example.recipe_rest_api.db.RecipeRepository;
import com.example.recipe_rest_api.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    static final Logger logger = LoggerFactory.getLogger(RecipeService.class);

    private final RecipeRepository recipeRepository;
    private final CategoryService categoryService;
    private final IngredientService ingredientService;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, CategoryService categoryService,
                         IngredientService ingredientService) {
        this.recipeRepository = recipeRepository;
        this.categoryService = categoryService;
        this.ingredientService = ingredientService;
    }

    public List<Recipe> getAll() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(Long id) {
        try {
            return recipeRepository.findById(id).stream().findFirst().orElseThrow();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean addRecipe(Recipe recipe) {

       boolean isPresent = categoryService.getAllCategories().stream().anyMatch(recipeCategory -> recipeCategory.getName().equals(recipe.getRecipeCategory().getName()));

        if (isPresent) {
           RecipeCategory recipeCategory = categoryService.getAllCategories().stream().filter(recipeCategory1 -> recipeCategory1.getName().equals(recipe.getRecipeCategory().getName())).findFirst().get();
           recipe.setRecipeCategory(recipeCategory);
       }

        if (recipe.getIngredients().size() > 1)
            ingredientService.saveAllIngredients(recipe.getIngredients());
        else
            ingredientService.saveIngredient(recipe.getIngredients().get(0));


        logger.info("POST RECIPE: " + recipe.toString());
        try {
                recipeRepository.save(recipe);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateRecipe(Recipe recipe, Long id) {
        logger.info("UPDATE: " + recipe.getLevel());
        try {
            Recipe recipeFound = recipeRepository.findById(id).stream().findFirst().orElseThrow();
            recipeFound.setTitle(recipe.getTitle());
            recipeFound.setDescription(recipe.getDescription());
            recipeFound.setCookingTime(recipe.getCookingTime());
            recipeFound.setImageUrl(recipe.getImageUrl());
            recipeFound.setPreparationTime(recipe.getPreparationTime());
            recipeFound.setLevel(recipe.getLevel());
            recipeFound.setRating(recipe.getRating());
            recipeRepository.save(recipe);
        } catch (Exception e) {
            return false;
        }
            return true;
    }

    public boolean deleteRecipe(Long id) {
        try {
            Recipe recipeFound = recipeRepository.findById(id).stream().findFirst().orElseThrow();
            recipeRepository.delete(recipeFound);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
