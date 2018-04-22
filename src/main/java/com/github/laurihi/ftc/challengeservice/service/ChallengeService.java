package com.github.laurihi.ftc.challengeservice.service;

import com.github.laurihi.ftc.challengeservice.model.Challenge;
import com.github.laurihi.ftc.challengeservice.persistence.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ChallengeService {

    @Autowired
    ChallengeRepository challengeRepository;

    public void initChallenge(){
        Challenge challenge = new Challenge();
        challenge.setName("New challenge");
        challenge.setBeginsOn(LocalDate.now().plusDays(7));
        challenge.setEndsOn(LocalDate.now().plusDays(14));
        challengeRepository.save(challenge);
    }

    public Iterable<Challenge> getChallenges(){
        return challengeRepository.findAll();
    }
}
