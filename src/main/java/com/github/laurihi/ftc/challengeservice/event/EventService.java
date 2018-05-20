package com.github.laurihi.ftc.challengeservice.event;

import com.github.laurihi.ftc.challengeservice.event.entity.EventStore;
import com.github.laurihi.ftc.challengeservice.event.persistence.ImmutableEventStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    ImmutableEventStoreRepository eventStoreRepository;


    public void addEvent(EventStore event){
        eventStoreRepository.save(event);
    }
}
