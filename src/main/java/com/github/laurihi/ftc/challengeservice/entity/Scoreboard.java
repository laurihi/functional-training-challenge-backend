package com.github.laurihi.ftc.challengeservice.entity;

import javax.persistence.*;

@Entity
public class Scoreboard {

    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
