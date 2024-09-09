package com.nirvana.app.models;

import java.util.List;

public class Recipe {
    private Long id;
    private String name;
    private List<FoodItem> ingredients;  // Ingredienti della ricetta
    private NutritionalFacts totalNutritionalFacts;  // Nutrienti totali della ricetta
    private int servings;  // Numero di porzioni
}


