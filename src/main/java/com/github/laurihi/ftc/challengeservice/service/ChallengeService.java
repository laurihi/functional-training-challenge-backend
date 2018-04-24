package com.github.laurihi.ftc.challengeservice.service;

import com.github.laurihi.ftc.challengeservice.model.Challenge;
import com.github.laurihi.ftc.challengeservice.model.Scoreboard;
import com.github.laurihi.ftc.challengeservice.persistence.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ChallengeService {

    @Autowired
    ChallengeRepository challengeRepository;


    public Challenge create(Challenge challenge) {

        Scoreboard scoreboard = new Scoreboard();

        challenge.setScoreboard(scoreboard);

        Challenge result = challengeRepository.save(challenge);
        return result;
    }
    
    public Iterable<Challenge> getChallenges(){
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
