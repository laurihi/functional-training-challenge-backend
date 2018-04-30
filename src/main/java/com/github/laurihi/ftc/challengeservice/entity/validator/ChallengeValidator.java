package com.github.laurihi.ftc.challengeservice.entity.validator;

import com.github.laurihi.ftc.challengeservice.entity.Challenge;


public class ChallengeValidator {

    private final Challenge challenge;

    public ChallengeValidator(Challenge challenge) {
        this.challenge = challenge;
    }

    public boolean isValid() {
        return hasNameSet() && hasValidDaterange() && hasMinimumOfOneExercise();
    }

    public boolean isValidDraft() {
        return hasNameSet();
    }

    private boolean hasNameSet(){
        return challenge.getName()!=null;
    }
    private boolean hasValidDaterange(){
        return challenge.getStartDate() != null && challenge.getEndDate() != null;
    }
    private boolean hasMinimumOfOneExercise(){
        return challenge.getExercises().size()!=0;
    }

}
