package com.hp.manner.controller;

import com.hp.manner.model.MeetingMinutes;
import com.hp.manner.service.MeetingServiceImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    private MeetingServiceImpl meetingService;

    @RequestMapping(value = "/minutes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public MeetingMinutes getMeetingMinutes(String id) {
        return meetingService.getMeetingMinutes(new ObjectId(id));
    }
}
