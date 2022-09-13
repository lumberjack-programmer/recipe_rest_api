package com.example.recipe_rest_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "measurement_id", referencedColumnName = "id")
    private Measurement measurement;


    @ManyToMany(mappedBy = "ingredients")
    private List<Recipe> recipes = new ArrayList<>();


    public Ingredient() {
    }

    public Ingredient( @NonNull String name, @NonNull Measurement measurement) {
        this.name = name;
        this.measurement = measurement;
    }

}
