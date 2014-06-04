package com.hp.manner.repository;

import com.hp.manner.model.Meeting;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends CrudRepository<Meeting, ObjectId> {
}
