package com.hp.manner.controller;

import com.hp.manner.model.ActionItem;
import com.hp.manner.model.Message;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

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

    @RequestMapping(value = "/actionItem", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ActionItem getActionItem() {
        ActionItem actionItem = new ActionItem();
        actionItem.setId(UUID.randomUUID().toString());
        actionItem.setContent("Learn Mongodb");
        actionItem.setOwner("Jason");
        actionItem.setStatus("50%");
        actionItem.setDueDate(new Date());
        return actionItem;
    }
}
