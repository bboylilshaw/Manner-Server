package com.hp.manner.repository;

import com.hp.manner.model.Item;
import com.hp.manner.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "items", path = "items")
public interface ItemRepository extends MongoRepository<Item, ObjectId> {

    @Override
    @RestResource(exported = false)
    void delete(ObjectId id);

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
