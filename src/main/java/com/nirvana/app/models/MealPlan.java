package com.nirvana.app.models;

import com.nirvana.app.utils.NutritionalFactsCalculator;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "meal_plans")
public class MealPlan implements NutritionalCalculable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // user associated with the plan
    private LocalDate date;

    // daily goal associated
    @ManyToOne
    @JoinColumn(name = "nutritional_goal_id")
    private NutritionalGoal dailyNutritionalGoal;

    // list of meals consumed during the day
    @OneToMany(mappedBy = "mealPlan") // 'mealPlan' refers to the field in Meal
    private List<Meal> meals;

    @OneToMany(mappedBy = "mealPlan")
    private List<NutritionalAdjustment> nutritionalAdjustments;

    @Transient
    // nutritional facts of the day
    private NutritionalFacts totalNutritionalFacts;
    @Override
    public NutritionalFacts getNutritionalFacts() {
        if (totalNutritionalFacts == null) {
            totalNutritionalFacts = NutritionalFactsCalculator.aggregateNutritionalFacts(this);
        }
        return totalNutritionalFacts;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    // status of the plan (completed, modified, in use)
    private String status;

}

