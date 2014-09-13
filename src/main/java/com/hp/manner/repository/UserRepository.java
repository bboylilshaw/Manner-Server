package com.hp.manner.repository;

import com.hp.manner.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends MongoRepository<User, ObjectId> {

    @Override
    @RestResource(exported = false)
    void delete(ObjectId id);

    @Override
    @RestResource(exported = false)
    void delete(User user);

    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends User> users);

    @Override
    @RestResource(exported = false)
    void deleteAll();

    User findByEmail(@Param("email") String email);
}
