package com.hp.manner.repository;

import com.hp.manner.config.AppConfig;
import com.hp.manner.config.WebMvcConfig;
import com.hp.manner.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, WebMvcConfig.class})
public class ItemRepositoryTest {

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