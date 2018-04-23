package com.github.laurihi.ftc.challengeservice.persistence;

import com.github.laurihi.ftc.challengeservice.model.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChallengeRepository extends CrudRepository<Challenge, Long> {

    @Query("Select c from Challenge c where c.beginsOn <= CURRENT_DATE and c.endsOn >= CURRENT_DATE")
    List<Challenge> findByStartBeforeAndEndAfter();

}
