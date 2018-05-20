package com.github.laurihi.ftc.challengeservice.event.action;

import com.github.laurihi.ftc.challengeservice.entity.Challenge;
import com.github.laurihi.ftc.challengeservice.entity.Exercise;
import com.github.laurihi.ftc.challengeservice.event.EventService;
import com.github.laurihi.ftc.challengeservice.event.entity.EventStore;
import com.github.laurihi.ftc.challengeservice.model.ExerciseEventDescriptor;
import com.github.laurihi.ftc.challengeservice.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AddExerciseAction {

    @Autowired
    EventService eventService;

    public void addExercise(Long challengeId, ExerciseEventDescriptor descriptor) {

        
        String exerciseName = descriptor.getExerciseName();
        double amount = descriptor.getAmount();

        EventStore event = new EventStore();
        event.setAggregateId(challengeId);
        event.setAggregateType("ExerciseEvent");

        event.setPayLoad("exercise:"+exerciseName+", amount:" + amount);
        eventService.addEvent(event);

    }
}
