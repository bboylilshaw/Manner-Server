package com.hp.manner.controller.rest;

import com.hp.manner.model.Item;
import com.hp.manner.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemRestController {

    @Autowired
    private ItemServiceImpl itemService;

    @RequestMapping(value = "/items/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> listAllItems() {
        return itemService.listAllItems();
    }

    @RequestMapping(value = "/items/owner/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> listItemsByOwner(@PathVariable String userId) {
        return itemService.listItemsByOwner(userId);
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Item getItem(@PathVariable String id) {
        return itemService.getItem(id);
    }

}
