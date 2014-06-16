package com.hp.manner.repository;

import com.hp.manner.model.Meeting;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends MongoRepository<Meeting, ObjectId> {
}
