package com.nirvana.app.models;

import javax.persistence.*;

@Entity
@Table(name = "nutritional_adjustments")
public class NutritionalAdjustment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "meal_plan_id")
    private MealPlan mealPlan;
    @ManyToOne
    @JoinColumn(name = "original_food_id")
    private FoodItem originalFood;
    @ManyToOne
    @JoinColumn(name = "adjustment_food_id")
    private FoodItem adjustmentFood;
    private String reason;  // es "fats excess"

    // Metodi getter e setter
}

