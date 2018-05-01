package com.github.laurihi.ftc.challengeservice.persistence;

import com.github.laurihi.ftc.challengeservice.entity.Participant;
import org.springframework.data.repository.CrudRepository;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {

}
