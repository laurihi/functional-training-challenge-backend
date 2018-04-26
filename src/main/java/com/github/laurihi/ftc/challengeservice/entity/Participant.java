package com.github.laurihi.ftc.challengeservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Participant {

    @Id
    @GeneratedValue
    private Long id;

    private String firstname;
    private String lastname;
    private String nickname;


}
