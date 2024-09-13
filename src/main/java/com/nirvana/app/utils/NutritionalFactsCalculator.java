package com.nirvana.app.utils;

import com.nirvana.app.models.*;

import java.util.List;

public class NutritionalFactsCalculator {

    // aggrega i fatti nutrizionali di una qualsiasi entità che implementa NutritionalCalculable
    public static NutritionalFacts aggregateNutritionalFacts(NutritionalCalculable calculable) {
        NutritionalFacts aggregatedFacts = new NutritionalFacts();

        if (calculable instanceof Meal) {
            Meal meal = (Meal) calculable;
            for (FoodItem item : meal.getFoodItems()) {
                aggregateNutritionalFacts(aggregatedFacts, item.getNutritionalFacts());
            }
            for (Recipe recipe : meal.getRecipes()) {
                aggregateNutritionalFacts(aggregatedFacts, recipe.getNutritionalFacts());
            }
        } else if (calculable instanceof Recipe) {
            Recipe recipe = (Recipe) calculable;
            for (FoodItem item : recipe.getIngredients()) {
                aggregateNutritionalFacts(aggregatedFacts, item.getNutritionalFacts());
            }
        } else if (calculable instanceof MealPlan) {
            MealPlan mealPlan = (MealPlan) calculable;
            for (Meal meal : mealPlan.getMeals()) {
                aggregateNutritionalFacts(aggregatedFacts, meal.getNutritionalFacts());
            }
        }

        return aggregatedFacts;
    }

    private static void aggregateNutritionalFacts(NutritionalFacts totalFacts, NutritionalFacts factsToAdd) {
        totalFacts.setCalories(totalFacts.getCalories() + factsToAdd.getCalories());
        totalFacts.setProtein(totalFacts.getProtein() + factsToAdd.getProtein());
        totalFacts.setCarbohydrates(totalFacts.getCarbohydrates() + factsToAdd.getCarbohydrates());
        totalFacts.setSugars(totalFacts.getSugars() + factsToAdd.getSugars());
        totalFacts.setFat(totalFacts.getFat() + factsToAdd.getFat());
        totalFacts.setSaturatedFat(totalFacts.getSaturatedFat() + factsToAdd.getSaturatedFat());
        totalFacts.setTransFat(totalFacts.getTransFat() + factsToAdd.getTransFat());
        totalFacts.setFiber(totalFacts.getFiber() + factsToAdd.getFiber());
        totalFacts.setCholesterol(totalFacts.getCholesterol() + factsToAdd.getCholesterol());
        totalFacts.setSodium(totalFacts.getSodium() + factsToAdd.getSodium());
        totalFacts.setPotassium(totalFacts.getPotassium() + factsToAdd.getPotassium());
        totalFacts.setCalcium(totalFacts.getCalcium() + factsToAdd.getCalcium());
        totalFacts.setIron(totalFacts.getIron() + factsToAdd.getIron());
        totalFacts.setVitaminA(totalFacts.getVitaminA() + factsToAdd.getVitaminA());
        totalFacts.setVitaminC(totalFacts.getVitaminC() + factsToAdd.getVitaminC());
        totalFacts.setVitaminD(totalFacts.getVitaminD() + factsToAdd.getVitaminD());
    }
}
