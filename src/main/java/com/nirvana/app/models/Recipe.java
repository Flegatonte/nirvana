package com.nirvana.app.models;

import com.nirvana.app.utils.NutritionalFactsCalculator;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe implements NutritionalCalculable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    private List<FoodItem> ingredients;

    @Transient
    private NutritionalFacts totalNutritionalFacts;

    @Override
    public NutritionalFacts getNutritionalFacts() {
        if (totalNutritionalFacts == null) {
            totalNutritionalFacts = NutritionalFactsCalculator.aggregateNutritionalFacts(this);
        }
        return totalNutritionalFacts;
    }

    public List<FoodItem> getIngredients() {
        return ingredients;
    }

    // getter e setter
}
