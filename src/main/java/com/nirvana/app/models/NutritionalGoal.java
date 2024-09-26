package com.nirvana.app.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.persistence.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.annotations.Type;

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

    private double calcium;   // calcium goal (mg)
    private double iron;      // iron goal (mg)
    private double vitaminA;  // vitamin A goal (µg)
    private double vitaminC;  // vitamin C goal (mg)
    private double vitaminD;  // vitamin D goal (µg)

    // additional nutrients stored as JSON
    @Column(columnDefinition = "json")
    private String additionalNutrientsJson;

    @OneToMany(mappedBy = "dailyNutritionalGoal")
    private List<MealPlan> mealPlans;

    // constructor for a default healthy individual
    public NutritionalGoal() {
        this.calories = 2000;
        this.protein = 50;
        this.carbohydrates = 275;
        this.sugars = 30;
        this.fats = 70;
        this.saturatedFat = 20;
        this.transFat = 0;
        this.fiber = 30;
        this.cholesterol = 300;
        this.sodium = 2300;
        this.potassium = 3500;

        this.calcium = 1000;
        this.iron = 18;
        this.vitaminA = 900;
        this.vitaminC = 90;
        this.vitaminD = 20;

        // Initialize an empty map and store it as JSON
        Map<String, Double> additionalNutrients = new HashMap<>();
        setAdditionalNutrients(additionalNutrients);
    }

    // Method to add additional nutrients
    public void addAdditionalNutrient(String nutrient, double amount) {
        Map<String, Double> additionalNutrients = getAdditionalNutrients();
        additionalNutrients.put(nutrient, amount);
        setAdditionalNutrients(additionalNutrients);
    }

    // getters and setters for additional nutrients using JSON
    public Map<String, Double> getAdditionalNutrients() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(additionalNutrientsJson, HashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public void setAdditionalNutrients(Map<String, Double> additionalNutrients) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.additionalNutrientsJson = objectMapper.writeValueAsString(additionalNutrients);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    // Other getters and setters
    // ...
}
