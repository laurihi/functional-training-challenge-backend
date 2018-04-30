package com.github.laurihi.ftc.challengeservice.entity.validator;

import com.github.laurihi.ftc.challengeservice.entity.Challenge;

import java.time.LocalDate;


public class ChallengeValidator {

    private final Challenge challenge;

    public ChallengeValidator(Challenge challenge) {
        this.challenge = challenge;
    }

    public boolean isValid() {
        return hasNameSet() && hasValidDateConfiguration() && hasMinimumOfOneExercise();
    }

    public boolean isValidDraft() {
        return hasNameSet();
    }

    private boolean hasNameSet(){
        return challenge.getName()!=null;
    }

    private boolean hasValidDateConfiguration(){
        return hasValidStartDate() && hasValidEndDate();
    }

    private boolean hasValidStartDate(){
        return challenge.getStartDate() != null && dateIsAfterOrEqual(challenge.getStartDate(), LocalDate.now());
    }

    private boolean hasValidEndDate(){
        return challenge.getEndDate() != null && dateIsAfterOrEqual(challenge.getEndDate(), challenge.getStartDate());
    }

    private boolean dateIsAfterOrEqual(LocalDate dateToCompare, LocalDate referenceDate){
        return dateToCompare.isAfter(referenceDate) || dateToCompare.isEqual(referenceDate);
    }
    private boolean hasMinimumOfOneExercise(){
        return challenge.getExercises().size()!=0;
    }

}
