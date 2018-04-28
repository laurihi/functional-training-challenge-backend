package com.github.laurihi.ftc.challengeservice.service;

import com.github.laurihi.ftc.challengeservice.entity.Challenge;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.Assert.*;


@Profile("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengeServiceTest {

    @Autowired
    ChallengeService challengeService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void savedChallengeShouldBeFoundWhenGettingAll() {

        Challenge challenge = new Challenge();
        challenge.setBeginsOn(LocalDate.now().minusDays(1));
        challenge.setEndsOn(LocalDate.now().plusDays(1));
        challenge.setName("Name");
        Challenge savedChallenge = challengeService.create(challenge);

        Collection<Challenge> challenges = challengeService.getChallenges();
        assertTrue(challenges.contains(savedChallenge));
    }

}