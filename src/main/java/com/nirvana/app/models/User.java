package com.nirvana.app.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;  // ensure password encryption is handled securely

    // personal details
    private String gender;  // gender (e.g., "M", "F", "Other")
    private LocalDate dateOfBirth;  // date of birth
    private double height;  // height (in cm or m)
    private double weight;  // weight (in kg)

    // nutritional and fitness goals
    @OneToMany(mappedBy = "user")
    private NutritionalGoal nutritionalGoal;  // object containing personalized nutritional goals
//    private FitnessGoals fitnessGoals;  // fitness-related goals
/*
    // dietary preferences
    private List<String> dietaryPreferences;  // e.g., vegetarian, vegan, gluten-free
    private List<String> allergies;  // potential allergies (e.g., nuts, lactose)
    private List<String> dislikedFoods;  // disliked foods

    // health conditions and medical information
    private List<String> medicalConditions;  // e.g., diabetes, hypertension
    private double dailyCaloricNeeds;  // daily caloric needs, calculated or user-defined */

    // preferences for handling cheats
    private boolean autoAdjustMeals;  // if enabled, automatically adjust meals based on cheats

    // history and progress tracking
    @OneToMany(mappedBy = "user")
    private List<MealPlan> mealHistory;  // history of daily meal plans
    //    private List<Workout> workoutHistory;  // history of workouts
    @OneToMany(mappedBy = "user")
    private List<WeightEntry> weightHistory;  // history of weight entries

    // weight unit preference
    private WeightUnit weightUnit;  // unit of measurement for weight (e.g., "kg" or "lbs")

    // getter and setter methods
}
