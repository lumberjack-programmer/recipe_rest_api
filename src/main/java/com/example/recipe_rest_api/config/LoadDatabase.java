package com.example.recipe_rest_api.config;


import com.example.recipe_rest_api.db.RecipeRepository;
import com.example.recipe_rest_api.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;
import java.util.List;


@Configuration
@EnableTransactionManagement
public class LoadDatabase {

    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);


//    @Bean
//    CommandLineRunner initDatabase(RecipeRepository recipeRepository) {
//
//                Measurement measurement1 = new Measurement(4.5, Unit.PIECE);
//
//
//        Ingredient ingredient1 = new Ingredient("chicken", measurement1);
//
//
//        List<Ingredient> ingredients = Arrays.asList(ingredient1, ingredient1);
////        RecipeCategory popular = new RecipeCategory("Popular");
//        RecipeCategory popular2 = new RecipeCategory("Popular");
//        popular2.setId(5L);
//
//        return args -> {
//            logger.info("Preloading " + recipeRepository.save(
//                    new Recipe(popular2, "Avocado Salad",
//                            "Made with an abundance of rich and creamy avocados, vibrant tomatoes, crisp cucumbers, bright red onions and a fresh herb dressing. A healthy side that's perfect for a summer lunch or dinner!,",
//                            "https://www.cookingclassy.com/wp-content/uploads/2020/06/avocado-salad-7-500x500.jpg",
//                            15, 15, 5.0, 214.0, Level.EASY,  ingredients)
//            ));
//        };
//    }
}