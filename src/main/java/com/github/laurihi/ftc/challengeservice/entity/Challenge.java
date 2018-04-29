package com.github.laurihi.ftc.challengeservice.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

@Entity
public class Challenge {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private LocalDate startDate;
    private LocalDate endDate;

    @ElementCollection
    private Map<String, Exercise> exercises;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
