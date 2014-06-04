package com.hp.manner.repository;

import com.hp.manner.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, ObjectId> {

    public User findByFirstName(String firstName);

    public User findByLastName(String lastName);

    public User findByEmail(String email);

    public User findByCommonName(String commonName);

}
