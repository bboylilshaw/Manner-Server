package com.hp.manner.repository;

import com.hp.manner.model.Item;
import com.hp.manner.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, ObjectId> {
    public List<Item> findByOwner(User owner);
}
