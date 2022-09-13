package com.example.recipe_rest_api.db;

import com.example.recipe_rest_api.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.recipe_rest_api.projection.InlineCategoryIngredient;

@RepositoryRestResource(excerptProjection = InlineCategoryIngredient.class)
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
