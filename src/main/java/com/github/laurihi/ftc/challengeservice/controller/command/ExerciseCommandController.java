package com.github.laurihi.ftc.challengeservice.controller.command;

import com.github.laurihi.ftc.challengeservice.action.AddExerciseAction;
import com.github.laurihi.ftc.challengeservice.action.RemoveExerciseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
@RequestMapping("/cmd")
public class ExerciseCommandController {

    @Autowired
    AddExerciseAction addExerciseAction;

    @Autowired
    RemoveExerciseAction removeExerciseAction;

    @RequestMapping(value = "/exercise", method = RequestMethod.POST)
    public void addExerciseEvent(){
        addExerciseAction.addExercise();
    }

    @RequestMapping(value = "/exercise", method = RequestMethod.DELETE)
    public void removeExerciseEvent(){
        removeExerciseAction.removeExercise();
    }
}
