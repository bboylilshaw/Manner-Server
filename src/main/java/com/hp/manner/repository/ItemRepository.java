package com.hp.manner.repository;

import com.hp.manner.model.Item;
import com.hp.manner.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "items", path = "items")
public interface ItemRepository extends MongoRepository<Item, ObjectId> {

    public List<Item> findByOwner(User owner);
}
