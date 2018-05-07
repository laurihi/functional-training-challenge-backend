package com.github.laurihi.ftc.challengeservice.event.persistence;

import com.github.laurihi.ftc.challengeservice.event.entity.EventStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;

import java.util.Collection;

import static org.junit.Assert.assertTrue;

@Profile("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class EventStoreRepositoryTest {

    @Autowired
    ImmutableEventStoreRepository eventStoreRepository;

    @Test
    public void creatingNewShouldWork(){
        EventStore eventRow = new EventStore(1l, "type", "payload", 1);
        eventStoreRepository.save(eventRow);

        Collection<EventStore> all = eventStoreRepository.findAll();
        assertTrue(all.size() == 1);
    }

    @Test(expected = TransactionSystemException.class)
    public void updatingRecordDoesNotWork(){
        EventStore eventRow = new EventStore(1l, "type", "payload", 1);
        EventStore saved = eventStoreRepository.save(eventRow);
        saved.setAggregateId(45l);
        eventStoreRepository.save(saved);
    }


    @Test(expected = UnsupportedOperationException.class)
    public void deleteByEntityNotAllowed(){
        EventStore eventRow = new EventStore(1l, "type", "payload", 1);
        EventStore saved = eventStoreRepository.save(eventRow);

        eventStoreRepository.delete(saved);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void deleteByIdNotAllowed(){
        EventStore eventRow = new EventStore(1l, "type", "payload", 1);
        EventStore saved = eventStoreRepository.save(eventRow);

        eventStoreRepository.deleteById(saved.getId());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void deleteAllNotAllowed(){
        EventStore eventRow = new EventStore(1l, "type", "payload", 1);
        eventStoreRepository.save(eventRow);
        eventStoreRepository.deleteAll();

    }

    @Test(expected = UnsupportedOperationException.class)
    public void deleteByIteratorNotAllowed(){
        EventStore eventRow = new EventStore(1l, "type", "payload", 1);
        eventStoreRepository.save(eventRow);

        Iterable<EventStore> all = eventStoreRepository.findAll();
        eventStoreRepository.deleteAll(all);
    }
}