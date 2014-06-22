package com.hp.manner.repository;

import com.hp.manner.model.Item;
import com.hp.manner.test.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemRepositoryTest extends BaseTest {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testFindByOwner() throws Exception {
        List<Item> items = itemRepository.findByOwner(userRepository.findByEmail("yao.xiao@hp.com"));
        items.forEach(e -> System.out.println(e.getContent()));
    }
}