package com.github.laurihi.ftc.challengeservice.service;

import com.github.laurihi.ftc.challengeservice.persistence.ActionRepository;
import com.github.laurihi.ftc.challengeservice.persistence.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionService {


    @Autowired
    ChallengeRepository challengeRepository;

    @Autowired
    ActionRepository actionRepository;

}
