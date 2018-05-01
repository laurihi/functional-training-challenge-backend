package com.github.laurihi.ftc.challengeservice.service;

import com.github.laurihi.ftc.challengeservice.entity.Challenge;
import com.github.laurihi.ftc.challengeservice.entity.Exercise;
import com.github.laurihi.ftc.challengeservice.entity.Participant;
import com.github.laurihi.ftc.challengeservice.entity.validator.builder.ChallengeBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;



@Profile("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ChallengeServiceTest {

    @Autowired
    ChallengeService challengeService;

    @Before
    public void setUp() throws Exception {
    }

    @Test(expected = IllegalArgumentException.class)
    public void createNotSuccesfulWithNoStartDate(){
        Challenge challenge = new Challenge();
        challenge.setName("Challenge");
        challenge.setEndDate(LocalDate.now().plusDays(1));

        challengeService.create(challenge);
    }

    @Test
    public void savedChallengeShouldBeFoundWhenGettingAll() {

        Challenge challenge = new Challenge();
        challenge.setStartDate(LocalDate.now());
        challenge.setEndDate(LocalDate.now().plusDays(1));
        challenge.setName("Name");
        Exercise exercise = new Exercise();
        exercise.setExerciseName("commute-by-walking");
        challenge.getExercises().put(exercise.getExerciseName(), exercise);
        Challenge savedChallenge = challengeService.create(challenge);

        Collection<Challenge> challenges = challengeService.getChallenges();
        assertTrue(challenges.contains(savedChallenge));
    }

    @Test
    public void savedChallengeShouldRetainExercises() {

        Challenge challenge = new Challenge();
        challenge.setStartDate(LocalDate.now());
        challenge.setEndDate(LocalDate.now().plusDays(1));
        challenge.setName("Name");

        Exercise first = new Exercise();
        first.setExerciseName("commute-by-walking");
        Exercise second = new Exercise();
        second.setExerciseName("commute-by-cycling");

        Exercise notAdded = new Exercise();
        notAdded.setExerciseName("not-added");

        challenge.getExercises().put(first.getExerciseName(), first);
        challenge.getExercises().put(second.getExerciseName(), second);

        Challenge savedChallenge = challengeService.create(challenge);

        assertThat(savedChallenge.getExercises().values(), hasItems( first, second ));
        assertThat(savedChallenge.getExercises().values(), not(hasItem(notAdded)));

        assertEquals(savedChallenge.getExercises().get("commute-by-cycling"), second);
    }

    @Test
    public void participantCanJoinChallenge(){

        ChallengeBuilder builder = new ChallengeBuilder();
        Challenge challenge = builder.withName("Challenge")
                .withStartDate(LocalDate.now())
                .withEndDate(LocalDate.now().plusDays(1))
                .withExercise()
                .build();

        Participant participant = new Participant();
        participant.setFirstname("Participant");
        participant.setLastname("Lastname");

        challengeService.create(challenge);
        challengeService.join(participant, challenge);

        Challenge currentChallenge = challengeService.getCurrentChallenge();
        assertThat(currentChallenge.getParticipants().get(0), equalTo(participant));
        
    }
}