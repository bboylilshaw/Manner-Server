package com.hp.manner.service;

import com.hp.manner.model.Item;
import com.hp.manner.model.User;
import com.hp.manner.repository.ItemRepository;
import com.hp.manner.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> listItemsByOwner(String userId) {
        User user = userRepository.findOne(new ObjectId(userId));
        return itemRepository.findByOwner(user);
    }

    @Override
    public List<Item> listAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItem(String id) {
        return itemRepository.findOne(new ObjectId(id));
    }

}
