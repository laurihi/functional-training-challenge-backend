package com.github.laurihi.ftc.challengeservice.event.action;

import com.github.laurihi.ftc.challengeservice.event.EventService;
import com.github.laurihi.ftc.challengeservice.model.ExerciseEventDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddExerciseAction {

    @Autowired
    EventService eventService;

    public void addExercise(ExerciseEventDescriptor descriptor) {

    }
}
