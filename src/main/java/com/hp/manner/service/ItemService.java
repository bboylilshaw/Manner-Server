package com.hp.manner.service;

import com.hp.manner.model.Item;

import java.util.List;

public interface ItemService {
    public List<Item> viewActionItemsByOwner(String email);
}
