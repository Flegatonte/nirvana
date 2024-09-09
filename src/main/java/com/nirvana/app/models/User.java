package com.nirvana.app.models;

import java.time.LocalDate;
import java.util.List;

public class User {
    private Long id;
    private String username;
    private String email;
    private String password;  // Assicurati di gestire la crittografia in modo sicuro

    // Dati personali
    private String gender;  // Genere (es. "M", "F", "Altro")
    private LocalDate dateOfBirth;  // Data di nascita
    private double height;  // Altezza (in cm o m)
    private double weight;  // Peso (in kg)

    // Obiettivi nutrizionali e fitness
    private NutritionalGoals nutritionalGoals;  // Oggetto che contiene gli obiettivi nutrizionali personalizzati
//    private FitnessGoals fitnessGoals;  // Obiettivi relativi all'attività fisica
/*
    // Preferenze alimentari
    private List<String> dietaryPreferences;  // Es. vegetariano, vegano, senza glutine
    private List<String> allergies;  // Eventuali allergie (es. frutta a guscio, lattosio)
    private List<String> dislikedFoods;  // Cibi non graditi

    // Stato di salute e condizioni mediche
    private List<String> medicalConditions;  // Es. diabete, ipertensione
    private double dailyCaloricNeeds;  // Fabbisogno calorico giornaliero calcolato o impostato dall'utente */

    // Preferenze per la gestione dello sgarro
    private boolean autoAdjustMeals;  // Se attivo, modifica automaticamente i pasti in base agli sgarri

    // Storico e progressi
    private List<MealPlan> mealHistory;  // Storico dei piani alimentari giornalieri
//    private List<Workout> workoutHistory;  // Storico degli allenamenti
    private List<WeightEntry> weightHistory;  // Storico del peso nel tempo

    // Metodi getter e setter
}
