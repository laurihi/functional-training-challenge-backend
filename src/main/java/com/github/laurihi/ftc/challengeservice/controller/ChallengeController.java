package com.github.laurihi.ftc.challengeservice.controller;

import com.github.laurihi.ftc.challengeservice.model.Challenge;
import com.github.laurihi.ftc.challengeservice.service.ChallengeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@EnableSwagger2
@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    @Autowired
    ChallengeService challengeService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(LocalDate.parse(text, DateTimeFormatter.ISO_DATE));
            }

        });
    }

    @ApiOperation(value = "Create new challenge", nickname = "createChallenge")
    @RequestMapping(value="", method = RequestMethod.POST)
    public void createChallenge(Challenge challenge){
        challengeService.create(challenge);
    }

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Challenge currentChallenge(){

        return challengeService.getCurrentChallenge();

    }

    @ApiOperation(value = "Challenge running on", nickname = "queryAnyChallengeRunning")
    @RequestMapping(value = "/challenges-on", method = RequestMethod.GET)
    public boolean isChallengeRunningOn(LocalDate queryDate){
        return challengeService.isAnyChallengeRunningOn(queryDate);
    }
}
