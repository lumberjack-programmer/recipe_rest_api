package com.example.recipe_rest_api.db;

import com.example.recipe_rest_api.entity.RecipeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<RecipeCategory, Long> {
}
