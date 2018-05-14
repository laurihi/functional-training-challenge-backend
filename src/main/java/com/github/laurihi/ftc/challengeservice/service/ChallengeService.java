package com.github.laurihi.ftc.challengeservice.service;

import com.github.laurihi.ftc.challengeservice.entity.Challenge;
import com.github.laurihi.ftc.challengeservice.entity.Participant;
import com.github.laurihi.ftc.challengeservice.entity.validator.ChallengeValidator;
import com.github.laurihi.ftc.challengeservice.persistence.ChallengeRepository;
import com.github.laurihi.ftc.challengeservice.persistence.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service
public class ChallengeService {


    @Autowired
    ChallengeRepository challengeRepository;

    @Autowired
    ParticipantRepository participantRepository;

    public Challenge create(Challenge challenge) {
        ChallengeValidator validator = new ChallengeValidator(challenge);
        if(!validator.isValid()){
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

    public void join(Participant participant, Challenge challenge) {
        challenge.getParticipants().add(participant);
        participant.getChallenges().add(challenge);

        participantRepository.save(participant);
        challengeRepository.save(challenge);
    }

    public Challenge getChallenge(Long challengeId) {
        return challengeRepository.findById(challengeId).orElseThrow(EntityNotFoundException::new);
    }
}
