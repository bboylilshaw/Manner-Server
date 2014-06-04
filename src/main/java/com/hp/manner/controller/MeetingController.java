package com.hp.manner.controller;

import com.hp.manner.service.MeetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MeetingController {

    @Autowired
    private MeetingServiceImpl meetingService;

    //TODO: add meeting controllers
}
