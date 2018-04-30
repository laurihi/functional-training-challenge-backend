package com.github.laurihi.ftc.challengeservice.entity.validator;

import com.github.laurihi.ftc.challengeservice.entity.Challenge;
import com.github.laurihi.ftc.challengeservice.entity.validator.builder.ChallengeBuilder;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;


public class ChallengeValidatorTest {

    ChallengeValidator validator;
    ChallengeBuilder builder;

    @Before
    public void setUp() throws Exception {
        builder = new ChallengeBuilder();
    }

    @Test
    public void shouldBeValidWithNameStartAndEndSetProperly() {

        Challenge challenge = builder.withName("Name")
                .withStartDate(LocalDate.now())
                .withEndDate(LocalDate.now())
                .withExercise()
                .build();
        validator = new ChallengeValidator(challenge);

        boolean valid = validator.isValid();
        assertTrue(valid);
    }

    @Test
    public void shouldNotBeValidWithStartDateYesterday(){
        Challenge challenge = builder.withName("Name")
                .withStartDate(LocalDate.now().minusDays(1))
                .withEndDate(LocalDate.now())
                .withExercise()
                .build();
        validator = new ChallengeValidator(challenge);

        boolean valid = validator.isValid();
        assertFalse(valid);
    }

    @Test
    public void shouldNotBeValidWithNoExercises() {
        Challenge challenge = builder.withName("Name")
                .withStartDate(LocalDate.now())
                .withEndDate(LocalDate.now())
                .build();
        validator = new ChallengeValidator(challenge);
        boolean valid = validator.isValid();

        assertFalse(valid);
    }

    @Test
    public void shouldBeValidDraftWithNameStartAndEndSetProperly() {

        Challenge challenge = builder.withName("Name")
                .withStartDate(LocalDate.now())
                .withEndDate(LocalDate.now())
                .withExercise()
                .build();

        validator = new ChallengeValidator(challenge);
        boolean valid = validator.isValid();
        assertTrue(valid);
    }

}