package com.github.laurihi.ftc.challengeservice.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Challenge {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private LocalDate beginsOn;
    private LocalDate endsOn;

    @OneToOne(cascade = CascadeType.ALL)
    private Scoreboard scoreboard;

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

    public LocalDate getBeginsOn() {
        return beginsOn;
    }

    public void setBeginsOn(LocalDate beginsOn) {
        this.beginsOn = beginsOn;
    }

    public LocalDate getEndsOn() {
        return endsOn;
    }

    public void setEndsOn(LocalDate endsOn) {
        this.endsOn = endsOn;
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public void setScoreboard(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", beginsOn=" + beginsOn +
                ", endsOn=" + endsOn +
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
