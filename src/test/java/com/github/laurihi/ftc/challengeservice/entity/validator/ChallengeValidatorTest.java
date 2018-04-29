package com.github.laurihi.ftc.challengeservice.entity.validator;

import com.github.laurihi.ftc.challengeservice.entity.Challenge;
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
        validator = new ChallengeValidator();
    }

    @Test
    public void shouldBeValidWithNameStartAndEndSetProperly() {

        Challenge challenge = builder.withName("Name")
                .withStartDate(LocalDate.now())
                .withEndDate(LocalDate.now())
                .build();

        boolean valid = validator.isValid(challenge);
        assertTrue(valid);
    }

    @Test
    public void shouldBeValidDraftWithNameStartAndEndSetProperly() {

        Challenge challenge = builder.withName("Name")
                .withStartDate(LocalDate.now())
                .withEndDate(LocalDate.now())
                .build();

        boolean valid = validator.isValid(challenge);
        assertTrue(valid);
    }

    class ChallengeBuilder {

        private String name;
        private LocalDate startDate;
        private LocalDate endDate;

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

        public Challenge build() {

            Challenge result = new Challenge();
            result.setName(this.name);
            result.setStartDate(this.startDate);
            result.setEndDate(this.endDate);

            return result;
        }
    }
}