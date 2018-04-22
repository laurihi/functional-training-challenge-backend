package com.github.laurihi.ftc.challengeservice.persistence;

import com.github.laurihi.ftc.challengeservice.model.Challenge;
import org.springframework.data.repository.CrudRepository;

public interface ChallengeRepository extends CrudRepository<Challenge, Long> {
}
