package com.hp.manner.repository;

import com.hp.manner.domain.Item;
import com.hp.manner.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "items", path = "items")
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Override
    @RestResource(exported = false)
    void delete(Long id);

    @Override
    @RestResource(exported = false)
    void delete(Item item);

    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends Item> items);

    @Override
    @RestResource(exported = false)
    void deleteAll();

    List<Item> findByOwner(User owner);
}
