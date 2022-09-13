package com.example.recipe_rest_api.service;

import com.example.recipe_rest_api.db.CategoryRepository;
import com.example.recipe_rest_api.db.IngredientRepository;
import com.example.recipe_rest_api.entity.Ingredient;
import com.example.recipe_rest_api.entity.RecipeCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public boolean saveIngredient(Ingredient ingredient) {
        logger.error(ingredient.getName());
        ingredientRepository.save(ingredient);
        return true;
    }

    public boolean saveAllIngredients(List<Ingredient> ingredients) {
        ingredientRepository.saveAll(ingredients);
        return true;
    }
}
