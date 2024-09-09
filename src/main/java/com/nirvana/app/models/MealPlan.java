package com.nirvana.app.models;

import java.time.LocalDate;
import java.util.List;

public class MealPlan {
    private Long id;
    private User user;  // L'utente a cui è associato il piano alimentare
    private LocalDate date;  // Data del piano alimentare

    // Obiettivo giornaliero associato
    private NutritionalGoals dailyNutritionalGoals;

    // Lista dei pasti della giornata
    private List<Meal> meals;

    // Totali nutrizionali per il giorno
    private NutritionalFacts totalNutritionalFacts;

    // Stato del piano (es. "completo", "modificato dall'utente", "in esecuzione")
    private String status;

    // Metodi getter e setter
}

