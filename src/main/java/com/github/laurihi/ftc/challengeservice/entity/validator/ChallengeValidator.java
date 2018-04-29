package com.github.laurihi.ftc.challengeservice.entity.validator;

import com.github.laurihi.ftc.challengeservice.entity.Challenge;
import org.springframework.stereotype.Component;

@Component
public class ChallengeValidator {

    public boolean isValid(Challenge challenge) {
        return challenge.getBeginsOn() != null && challenge.getEndsOn() != null && challenge.getName() != null;
    }

    public boolean isValidDraft(Challenge challenge) {
        return true;
    }
}
