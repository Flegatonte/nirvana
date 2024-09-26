package com.nirvana.app.models;

import jakarta.persistence.*;
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
    private List<NutritionalGoal> nutritionalGoals;  // object containing personalized nutritional goals
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<NutritionalGoal> getNutritionalGoals() {
        return nutritionalGoals;
    }

    public void setNutritionalGoals(List<NutritionalGoal> nutritionalGoals) {
        this.nutritionalGoals = nutritionalGoals;
    }

    public boolean isAutoAdjustMeals() {
        return autoAdjustMeals;
    }

    public void setAutoAdjustMeals(boolean autoAdjustMeals) {
        this.autoAdjustMeals = autoAdjustMeals;
    }

    public List<MealPlan> getMealHistory() {
        return mealHistory;
    }

    public void setMealHistory(List<MealPlan> mealHistory) {
        this.mealHistory = mealHistory;
    }

    public List<WeightEntry> getWeightHistory() {
        return weightHistory;
    }

    public void setWeightHistory(List<WeightEntry> weightHistory) {
        this.weightHistory = weightHistory;
    }

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }
}
