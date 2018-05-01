package com.github.laurihi.ftc.challengeservice.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Challenge {

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public enum ChallengeState{
        DRAFT, // Challenge as draft, easier validations
        PUBLISHED, // Published challenge, waiting to start (not able to mark exercises)
        RUNNING, // Challenge running, one is able to mark exercises
        GRACE_PERIOD, // Grace period, challenge ended, one can still mark exercises
        ENDED // Challenge ended, not exercises can be marked anymore.
    }

    @Id
    @GeneratedValue
    private Long id;
    private ChallengeState state = ChallengeState.DRAFT;

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Map<String, Exercise> exercises = new HashMap<>();

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Challenge_Participant",
            joinColumns = {
                    @JoinColumn(name = "participant_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "challenge_id")
            })
    private List<Participant> participants = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChallengeState getState() {
        return state;
    }

    public void setState(ChallengeState state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate beginsOn) {
        this.startDate = beginsOn;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endsOn) {
        this.endDate = endsOn;
    }

    public Map<String, Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Map<String, Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endsOn=" + endDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Challenge challenge = (Challenge) o;
        return Objects.equals(id, challenge.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

}
