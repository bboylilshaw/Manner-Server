package com.hp.manner.repository;

import com.hp.manner.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    //@Query
    public User findByFirstName(String firstName);

    public User findByLastName(String lastName);

    public User findByEmail(String email);

    public User findByCommonName(String commonName);
}
