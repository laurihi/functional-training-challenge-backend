package com.github.laurihi.ftc.challengeservice.entity.validator;

import com.github.laurihi.ftc.challengeservice.entity.Challenge;
import org.springframework.stereotype.Component;


@Component
public class ChallengeValidator {

    public boolean isValid(Challenge challenge) {
        return hasNameSet(challenge) && hasValidDaterange(challenge) && hasMinimumOfOneExercise(challenge);
    }

    public boolean isValidDraft(Challenge challenge) {
        return hasNameSet(challenge);
    }

    private boolean hasNameSet(Challenge challenge){
        return challenge.getName()!=null;
    }
    private boolean hasValidDaterange(Challenge challenge){
        return challenge.getStartDate() != null && challenge.getEndDate() != null;
    }
    private boolean hasMinimumOfOneExercise(Challenge challenge){
        return challenge.getExercises().size()!=0;
    }

}
