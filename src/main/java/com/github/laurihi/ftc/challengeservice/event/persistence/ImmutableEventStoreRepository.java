package com.github.laurihi.ftc.challengeservice.event.persistence;

import com.github.laurihi.ftc.challengeservice.event.entity.EventStore;

import java.util.Collection;

public interface ImmutableEventStoreRepository extends ImmutableRepository<EventStore, Long> {

    Collection<EventStore> findAll();
}
