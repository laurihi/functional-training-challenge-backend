package com.github.laurihi.ftc.challengeservice.event.entity;

import org.hibernate.annotations.Immutable;
import org.springframework.data.domain.Persistable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PreUpdate;

@Entity
public class EventStore implements Persistable<Long> {


    public EventStore(){}

    public EventStore(long aggregateId, String aggregateType, String payLoad, int version) {
        this.aggregateId = aggregateId;
        this.aggregateType = aggregateType;
        this.payLoad = payLoad;
        this.version = version;
    }

    @Override
    public boolean isNew() {
        return this.id == null;
    }


    @Id
    @GeneratedValue
    private Long id;

    protected long aggregateId;

    protected String aggregateType;
    protected String payLoad;
    protected int version;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getAggregateId() {
        return aggregateId;
    }

    public void setAggregateId(long aggregateId) {
        this.aggregateId = aggregateId;
    }

    public String getAggregateType() {
        return aggregateType;
    }

    public void setAggregateType(String aggregateType) {
        this.aggregateType = aggregateType;
    }

    public String getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(String payLoad) {
        this.payLoad = payLoad;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


    @PreUpdate
    public void handleUpdate(){
        throw new UnsupportedOperationException("Updating immutable records not supported");
    }
}
