package com.github.laurihi.ftc.challengeservice.event.action;

import com.github.laurihi.ftc.challengeservice.model.ExerciseEventDescriptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@Profile("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AddExerciseActionTest {

    @Autowired
    AddExerciseAction addExerciseAction;

    @Test
    public void shouldHaveCorrectMethodSignature() {
        ExerciseEventDescriptor descriptor = null;
        addExerciseAction.addExercise(descriptor);
    }
}