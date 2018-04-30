package com.github.laurihi.ftc.challengeservice.entity.validator;

import com.github.laurihi.ftc.challengeservice.entity.Challenge;
import com.github.laurihi.ftc.challengeservice.entity.Exercise;
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

    class ChallengeBuilder {

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
}