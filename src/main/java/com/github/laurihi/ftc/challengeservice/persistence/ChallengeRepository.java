package com.github.laurihi.ftc.challengeservice.persistence;

import com.github.laurihi.ftc.challengeservice.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface ChallengeRepository extends CrudRepository<Challenge, Long> {

    Collection<Challenge> findAll();

    @Query("Select c from Challenge c where c.startDate <= :queryDate and c.endDate >= :queryDate")
    List<Challenge> findByStartBeforeAndEndAfter(@Param("queryDate") LocalDate queryDate);
}
