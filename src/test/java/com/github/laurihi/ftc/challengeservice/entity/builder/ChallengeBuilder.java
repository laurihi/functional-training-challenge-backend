package com.github.laurihi.ftc.challengeservice.entity.builder;

import com.github.laurihi.ftc.challengeservice.entity.Challenge;
import com.github.laurihi.ftc.challengeservice.entity.Exercise;

import java.time.LocalDate;

public class ChallengeBuilder {

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Exercise exercise;

    public ChallengeBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ChallengeBuilder withStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public ChallengeBuilder withEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public ChallengeBuilder withExercise() {
        this.exercise = new Exercise();
        this.exercise.setExerciseName("exercise-name");
        return this;
    }

    public Challenge build() {

        Challenge result = new Challenge();
        result.setName(this.name);
        result.setStartDate(this.startDate);
        result.setEndDate(this.endDate);

        if(this.exercise!=null){
            result.getExercises().put(this.exercise.getExerciseName(), this.exercise);
        }

        return result;
    }

}
