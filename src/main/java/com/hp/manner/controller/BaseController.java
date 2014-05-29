package com.hp.manner.controller;

import com.hp.manner.model.Message;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Message hello() {
        Message message = new Message(1L,"Hello, World!");
        return message;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "hello";
    }
}
