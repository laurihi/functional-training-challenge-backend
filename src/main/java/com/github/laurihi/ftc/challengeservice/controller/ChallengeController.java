package com.github.laurihi.ftc.challengeservice.controller;

import com.github.laurihi.ftc.challengeservice.model.Challenge;
import com.github.laurihi.ftc.challengeservice.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChallengeController {

    @Autowired
    ChallengeService challengeService;

    @RequestMapping("/challenges")
    public String challenges(){

        Iterable<Challenge> challenges = challengeService.getChallenges();
        logChallengeIteratorLength(challenges);

        challengeService.initChallenge();

        challenges = challengeService.getChallenges();
        logChallengeIteratorLength(challenges);

        return "TODO: finish the project";
    }
    private void logChallengeIteratorLength(Iterable<Challenge> challenges) {
        System.out.println(challenges.spliterator().getExactSizeIfKnown());

    }
}
