package com.github.laurihi.ftc.challengeservice.service;

import com.github.laurihi.ftc.challengeservice.entity.Challenge;
import com.github.laurihi.ftc.challengeservice.entity.Scoreboard;
import com.github.laurihi.ftc.challengeservice.entity.validator.ChallengeValidator;
import com.github.laurihi.ftc.challengeservice.persistence.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service
public class ChallengeService {

    @Autowired
    ChallengeValidator validator;

    @Autowired
    ChallengeRepository challengeRepository;


    public Challenge create(Challenge challenge) {

        if(!validator.isValid(challenge)){
            throw new IllegalArgumentException("Invalid challenge configuration.");
        }

        Challenge result = challengeRepository.save(challenge);

        return result;
    }
    
    public Collection<Challenge> getChallenges(){

        return challengeRepository.findAll();
    }

    public Challenge getCurrentChallenge() {
        LocalDate now = LocalDate.now();
        List<Challenge> challenges = challengeRepository.findByStartBeforeAndEndAfter(now);
        return challenges.isEmpty() ? null : challenges.get(0);
    }

    public boolean isAnyChallengeRunningOn(LocalDate queryDate) {
        List<Challenge> challengesRunningOnDate = challengeRepository.findByStartBeforeAndEndAfter(queryDate);
        return !challengesRunningOnDate.isEmpty();
    }
}
