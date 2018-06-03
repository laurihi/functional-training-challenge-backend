package com.github.laurihi.ftc.challengeservice.model;

import java.time.LocalDate;

public class ExerciseEventDescriptor {

    private String exerciseName;
    private double amount;
    private LocalDate exerciseDate;

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getExerciseDate() {
        return exerciseDate;
    }

    public void setExerciseDate(LocalDate exerciseDate) {
        this.exerciseDate = exerciseDate;
    }
}
