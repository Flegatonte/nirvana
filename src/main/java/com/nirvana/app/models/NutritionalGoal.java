package com.nirvana.app.models;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.*;

@Entity
@Table(name = "nutritional_facts")
public class NutritionalGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private double calories;  // daily caloric goal (kcal)

    // macronutrient goals
    private double protein;   // protein goal (g)
    private double carbohydrates;  // carbohydrate goal (g)
    private double sugars;    // sugar goal (g)
    private double fats;  // total fat goal (g)
    private double saturatedFat;   // saturated fat goal (g)
    private double transFat;  // trans fat goal (g)
    private double fiber;     // fiber goal (g)
    private double cholesterol;  // cholesterol goal (mg)
    private double sodium;    // sodium goal (mg)
    private double potassium; // potassium goal (mg)

    // micronutrient goals
    private double calcium;   // calcium goal (mg)
    private double iron;      // iron goal (mg)
    private double vitaminA;  // vitamin A goal (µg)
    private double vitaminC;  // vitamin C goal (mg)
    private double vitaminD;  // vitamin D goal (µg)

    // additional nutrients (for custom user-defined goals)
    private Map<String, Double> additionalNutrients;  // key: nutrient name, value: goal amount (in g, mg, µg)

    // constructor for a default healthy individual
    public NutritionalGoal() {
        this.calories = 2000;  // default to 2000 kcal/day
        this.protein = 50;  // default 50g protein
        this.carbohydrates = 275;  // default 275g carbohydrates
        this.sugars = 30;  // default 30g sugar
        this.fats = 70;  // default 70g total fat
        this.saturatedFat = 20;  // default 20g saturated fat
        this.transFat = 0;  // avoid trans fat
        this.fiber = 30;  // default 30g fiber
        this.cholesterol = 300;  // default 300mg cholesterol
        this.sodium = 2300;  // default 2300mg sodium
        this.potassium = 3500;  // default 3500mg potassium

        // standard micronutrient goals
        this.calcium = 1000;  // in mg
        this.iron = 18;  // in mg
        this.vitaminA = 900;  // in µg
        this.vitaminC = 90;  // in mg
        this.vitaminD = 20;  // in µg

        // initialize the map for additional nutrients
        this.additionalNutrients = new HashMap<>();
    }

    // methods to modify or extend goals
    public void setCustomMacronutrientGoal(double protein, double carbs, double fats) {
        this.protein = protein;
        this.carbohydrates = carbs;
        this.fats = fats;
    }

    public void addAdditionalNutrient(String nutrient, double amount) {
        this.additionalNutrients.put(nutrient, amount);
    }

    // getter and setter methods
}
