package com.github.laurihi.ftc.challengeservice.event.action;

import com.github.laurihi.ftc.challengeservice.event.entity.EventStore;
import com.github.laurihi.ftc.challengeservice.event.persistence.ImmutableEventStoreRepository;
import com.github.laurihi.ftc.challengeservice.model.ExerciseEventDescriptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@Profile("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AddExerciseActionTest {

    @Autowired
    AddExerciseAction addExerciseAction;

    @Autowired
    ImmutableEventStoreRepository repository;

    @Test
    public void addExerciseActionShouldSaveEventStoreItem() {

        ExerciseEventDescriptor descriptor = new ExerciseEventDescriptor();
        descriptor.setAmount(1.0d);
        descriptor.setExerciseName("ExerciseName");

        addExerciseAction.addExercise(1l, descriptor);

        Collection<EventStore> events = repository.findAll();
        final EventStore event = events.iterator().next();
        assertTrue(event.getPayLoad().contains(descriptor.getExerciseName()));
    }
}