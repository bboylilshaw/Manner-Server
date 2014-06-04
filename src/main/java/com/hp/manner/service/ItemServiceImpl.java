package com.hp.manner.service;

import com.hp.manner.model.Item;
import com.hp.manner.model.User;
import com.hp.manner.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> viewActionItemsByOwner(String email) {

        User user = userService.getUserByEmail(email);

        return itemRepository.findByOwner(user);
    }

    @Override
    public List<Item> listAllItems() {
        return (List<Item>) itemRepository.findAll();
    }
}
