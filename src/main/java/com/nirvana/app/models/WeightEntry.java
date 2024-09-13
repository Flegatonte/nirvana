package com.nirvana.app.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "weight_entries")
public class WeightEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private double weight;  // weight in the user's preferred unit
    private String notes;  // optional notes about the weight entry
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // reference to the user associated with this weight entry

    // constructor
    public WeightEntry(LocalDate date, double weight, User user) {
        this.date = date;
        this.weight = weight;
        this.user = user;
    }

    public WeightEntry(LocalDate date, double weight, User user, String notes) {
        this.date = date;
        this.weight = weight;
        this.user = user;
        this.notes = notes;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
