package com.nirvana.app.models;

import com.nirvana.app.utils.NutritionalFactsCalculator;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "meals")
public class Meal implements NutritionalCalculable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String type;
        @ManyToMany
        @JoinTable(
                name = "meal_food_items",   // name of the join table
                joinColumns = @JoinColumn(name = "meal_id"),  // foreign key column for meal
                inverseJoinColumns = @JoinColumn(name = "food_item_id")  // foreign key column for food
        )
        private List<FoodItem> foodItems;  // single elements included
        @ManyToMany
        @JoinTable(
                name = "meal_recipes",  // Name of the join table
                joinColumns = @JoinColumn(name = "meal_id"),  // Foreign key column for Meal
                inverseJoinColumns = @JoinColumn(name = "recipe_id")  // Foreign key column for Recipe
        )
        private List<Recipe> recipes;  // recipes included in the meal
        @Transient

        private NutritionalFacts totalNutritionalFacts; // calculated summing up all the element in the meal

        // relationship with MealPlan
        @ManyToOne
        @JoinColumn(name = "meal_plan_id")
        private MealPlan mealPlan;

        @Override
        public NutritionalFacts getNutritionalFacts() {
                if (totalNutritionalFacts == null) {
                        totalNutritionalFacts = NutritionalFactsCalculator.aggregateNutritionalFacts(this);
                }
                return totalNutritionalFacts;
        }

        public List<FoodItem> getFoodItems() {
                return foodItems;
        }

        public List<Recipe> getRecipes() {
                return recipes;
        }
    }


