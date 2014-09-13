package com.hp.manner.repository;

import com.hp.manner.AbstractIntegrationTest;
import com.hp.manner.model.Item;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void testFindByOwner() throws Exception {
        List<Item> items = itemRepository.findByOwner(userRepository.findByEmail("yao.xiao@hp.com"));
        items.forEach(e -> System.out.println(e.getContent()));
    }

    @Test
    public void testUpdateOwner() throws Exception {
        userRepository.findByEmail("john@jsmith.com");
    }

}