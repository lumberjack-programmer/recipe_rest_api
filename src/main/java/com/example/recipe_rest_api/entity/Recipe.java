package com.example.recipe_rest_api.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String title;
    @NonNull
    @Column(length = 1000)
    private String description;
    @NonNull
    private String imageUrl;
    @NonNull
    private int cookingTime;
    @NonNull
    private int preparationTime;
    @NonNull
    private double rating;
    private double calories;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "recipe_category_id", referencedColumnName = "id", nullable = false)
    private RecipeCategory recipeCategory;

    @NonNull
    @Column(columnDefinition = "ENUM('EASY', 'MEDIUM', 'HARD')")
    @Enumerated(EnumType.STRING)
    private Level level;


    @ManyToMany
    @JoinTable(name = "recipe_ingredient",
    joinColumns = @JoinColumn(name = "recipe_id"),
    inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    List<Ingredient> ingredients = new ArrayList<>();

    public Recipe() {
    }

    public Recipe(@NonNull RecipeCategory recipeCategory, @NonNull String title, @NonNull String description,
                  @NonNull String imageUrl, @NonNull int cookingTime, @NonNull int preparationTime,
                  @NonNull double rating, double calories, @NonNull Level level,
                  @NonNull List<Ingredient> ingredients) {
        this.recipeCategory = recipeCategory;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.cookingTime = cookingTime;
        this.preparationTime = preparationTime;
        this.rating = rating;
        this.calories = calories;
        this.level = level;
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", cookingTime=" + cookingTime +
                ", preparationTime=" + preparationTime +
                ", rating=" + rating +
                ", calories=" + calories +
                ", recipeCategory=" + recipeCategory +
                ", level=" + level +
                ", ingredients=" + ingredients +
                '}';
    }


    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }




}


