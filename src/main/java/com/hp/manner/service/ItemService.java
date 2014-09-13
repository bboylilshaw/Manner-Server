package com.hp.manner.service;

import com.hp.manner.model.Item;

import java.util.List;

public interface ItemService {

    List<Item> listItemsByOwner(String userId);

    List<Item> listAllItems();

    Item getItem(String id);

}
