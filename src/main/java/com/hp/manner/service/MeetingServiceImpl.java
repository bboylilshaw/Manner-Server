package com.hp.manner.service;

import com.hp.manner.model.MeetingMinutes;
import com.hp.manner.repository.MeetingRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    @Override
    public MeetingMinutes getMeetingMinutes(ObjectId id) {
        return meetingRepository.findOne(id);
    }
}
