package com.example.recipe_rest_api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    public RecipeCategory(@NonNull String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "RecipeCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
