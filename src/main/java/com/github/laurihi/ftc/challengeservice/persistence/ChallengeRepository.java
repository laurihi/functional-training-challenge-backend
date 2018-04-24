package com.github.laurihi.ftc.challengeservice.persistence;

import com.github.laurihi.ftc.challengeservice.model.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ChallengeRepository extends CrudRepository<Challenge, Long> {

    @Query("Select c from Challenge c where c.beginsOn <= :queryDate and c.endsOn >= :queryDate")
    List<Challenge> findByStartBeforeAndEndAfter(@Param("queryDate") LocalDate queryDate);
}
