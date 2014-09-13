package com.hp.manner.controller.rest;

import com.hp.manner.model.Item;
import com.hp.manner.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ItemRestController {

    @Autowired
    private ItemServiceImpl itemService;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<Item> listAllItems() {
        return itemService.listAllItems();
    }

}
