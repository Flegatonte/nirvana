package com.nirvana.app.models;

import javax.persistence.*;

@Entity
@Table(name = "nutritional_facts")
public class NutritionalFacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double calories;  // calories (kcal)
    private double protein;   // protein (g)
    private double carbohydrates;  // carbohydrates (g)
    private double sugars;    // sugars (g)
    private double fat;       // total fat (g)
    private double saturatedFat;   // saturated fat (g)
    private double transFat;  // trans fat (g)
    private double fiber;     // fiber (g)
    private double cholesterol;  // cholesterol (mg)
    private double sodium;    // sodium (mg)
    private double potassium; // potassium (mg)

    // additional micronutrients and vitamins
    private double calcium;   // calcium (mg)
    private double iron;      // iron (mg)
    private double vitaminA;  // vitamin A (µg)
    private double vitaminC;  // vitamin C (mg)
    private double vitaminD;  // vitamin D (µg)

    // getter and setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getSugars() {
        return sugars;
    }

    public void setSugars(double sugars) {
        this.sugars = sugars;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getSaturatedFat() {
        return saturatedFat;
    }

    public void setSaturatedFat(double saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public double getTransFat() {
        return transFat;
    }

    public void setTransFat(double transFat) {
        this.transFat = transFat;
    }

    public double getFiber() {
        return fiber;
    }

    public void setFiber(double fiber) {
        this.fiber = fiber;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public double getPotassium() {
        return potassium;
    }

    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    public double getCalcium() {
        return calcium;
    }

    public void setCalcium(double calcium) {
        this.calcium = calcium;
    }

    public double getIron() {
        return iron;
    }

    public void setIron(double iron) {
        this.iron = iron;
    }

    public double getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(double vitaminA) {
        this.vitaminA = vitaminA;
    }

    public double getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(double vitaminC) {
        this.vitaminC = vitaminC;
    }

    public double getVitaminD() {
        return vitaminD;
    }

    public void setVitaminD(double vitaminD) {
        this.vitaminD = vitaminD;
    }
}
