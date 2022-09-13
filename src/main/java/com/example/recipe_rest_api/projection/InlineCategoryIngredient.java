package com.example.recipe_rest_api.projection;

import com.example.recipe_rest_api.entity.Ingredient;
import com.example.recipe_rest_api.entity.Level;
import com.example.recipe_rest_api.entity.Recipe;
import com.example.recipe_rest_api.entity.RecipeCategory;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "inlineCategoryIngredient", types = { Recipe.class })
public interface InlineCategoryIngredient {

    Long getId();

    String getTitle();

    String getDescription();

    String getImageUrl();

    int getCookingTime();

    int getPreparationTime();

    double getRating();

    double getCalories();

    RecipeCategory getRecipeCategory();

    Level getLevel();

    List<Ingredient> getIngredients();
}
