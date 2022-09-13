package com.example.recipe_rest_api.controller;

import com.example.recipe_rest_api.entity.Ingredient;
import com.example.recipe_rest_api.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredientController {

    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/ingredients")
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @PostMapping("/ingredient")
    public boolean saveIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.saveIngredient(ingredient);
        return true;
    }
}
