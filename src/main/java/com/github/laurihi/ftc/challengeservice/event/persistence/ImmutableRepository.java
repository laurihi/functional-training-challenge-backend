package com.github.laurihi.ftc.challengeservice.event.persistence;

import org.springframework.data.domain.Persistable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface ImmutableRepository<T extends Persistable<Long>, ID extends Serializable> extends CrudRepository<T, ID> {


    @Override
    default void deleteById(ID id){
        throw new UnsupportedOperationException("Delete not supported");
    }

    @Override
    default void delete(T entity){
        throw new UnsupportedOperationException("Delete not supported");
    }

    @Override
    default void deleteAll(Iterable<? extends T> entities){
        throw new UnsupportedOperationException("Delete not supported");

    }

    @Override
    default void deleteAll(){
        throw new UnsupportedOperationException("Delete not supported");
    }


}
