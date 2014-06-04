package com.hp.manner.controller;

import com.hp.manner.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ItemController {

    @Autowired
    private ItemServiceImpl itemService;

    //TODO: add item controllers
}
