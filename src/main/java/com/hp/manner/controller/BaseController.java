package com.hp.manner.controller;

import com.hp.manner.model.User;
import com.hp.manner.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User signup(User user) throws Exception {
        return userService.signup(user);
    }

}
