package com.example.recipe_rest_api.controller;

import com.example.recipe_rest_api.entity.Recipe;
import com.example.recipe_rest_api.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {


    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes() {
        return recipeService.getAll();
    }

    @PostMapping(value = "/recipe")
    public boolean postRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }


    @PutMapping("/recipe/{id}")
    public boolean updateRecipe(@RequestBody Recipe recipe, @PathVariable Long id) {
        return recipeService.updateRecipe(recipe, id);
    }

    @DeleteMapping("/recipe/{id}")
    public boolean deleteRecipe(@PathVariable Long id) {
        return recipeService.deleteRecipe(id);
    }

    @GetMapping("/recipe/{id}")
    public Recipe getRecipeById(@PathVariable Long id) {
        return recipeService.getRecipeById(id);
    }


}
