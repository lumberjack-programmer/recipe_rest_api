package com.example.recipe_rest_api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;


    @NonNull
    private double measurement;

    @NonNull
    @Column(columnDefinition = "ENUM('KILOGRAM', 'GRAM', 'TEASPOON', 'TABLESPOON', 'LITER', 'MILLIMETER', 'PIECE', 'CUP')")
    @Enumerated(EnumType.STRING)
    private Unit unit;

    public Measurement() {
    }

    public Measurement( @NonNull double measurement, @NonNull Unit unit) {
        this.measurement = measurement;
        this.unit = unit;
    }

}


