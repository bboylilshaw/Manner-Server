package com.hp.manner.service;

import com.hp.manner.model.MeetingMinutes;
import org.bson.types.ObjectId;

public interface MeetingService {
    public MeetingMinutes getMeetingMinutes(ObjectId id);
}
