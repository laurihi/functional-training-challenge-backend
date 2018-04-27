package com.github.laurihi.ftc.challengeservice.entity;

import com.github.laurihi.ftc.challengeservice.entity.keys.ActionKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Action {

    @EmbeddedId
    private ActionKey id;

    private int amountDone;
    private int pointsGained;

}
