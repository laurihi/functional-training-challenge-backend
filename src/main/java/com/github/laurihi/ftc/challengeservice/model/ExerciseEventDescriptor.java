package com.github.laurihi.ftc.challengeservice.model;

public class ExerciseEventDescriptor {

    private String exerciseName;
    private int pointsPerUnit;
    private double amount;

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getPointsPerUnit() {
        return pointsPerUnit;
    }

    public void setPointsPerUnit(int pointsPerUnit) {
        this.pointsPerUnit = pointsPerUnit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
