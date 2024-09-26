package com.nirvana.app.models;

import jakarta.persistence.*;

@Entity
@Table(name = "food_items")
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // nutritional facts of the item
    @OneToOne
    @JoinColumn(name = "nutritional_facts_id")
    private NutritionalFacts nutritionalFacts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NutritionalFacts getNutritionalFacts() {
        return nutritionalFacts;
    }

    public void setNutritionalFacts(NutritionalFacts nutritionalFacts) {
        this.nutritionalFacts = nutritionalFacts;
    }
}