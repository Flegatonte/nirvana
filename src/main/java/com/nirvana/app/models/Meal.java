package com.nirvana.app.models;

import java.util.List;

public class Meal {
        private Long id;
        private String type;
        private List<FoodItem> foodItems;  // Singoli alimenti
        private List<Recipe> recipes;  // Ricette consumate durante il pasto
        private NutritionalFacts totalNutritionalFacts;

        // Metodi getter e setter
    }


