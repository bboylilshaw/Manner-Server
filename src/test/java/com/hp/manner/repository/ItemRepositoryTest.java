package com.hp.manner.repository;

import com.hp.manner.config.AppConfig;
import com.hp.manner.model.Item;
import com.hp.manner.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppConfig.class)
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        userRepository.deleteAll();
        User user = new User();
        user.setFirstName("Yao");
        user.setLastName("Xiao");
        user.setEmail("yao.xiao@hp.com");
        user.setCommonName("Jason");
        Set<String> groups = new HashSet<String>();
        groups.add("BMI");
        user.setGroup(groups);
        userRepository.save(user);

        itemRepository.deleteAll();
        Item item = new Item();
        item.setContent("Learn Spring Data Mongodb");
        item.setPriority("High");
        item.setDueDate(new Date());
        item.setStatus("50%");
        item.setOwner(user);
        itemRepository.save(item);
    }

    @Test
    public void testFindByOwner() throws Exception {
        List<Item> items = itemRepository.findByOwner(userRepository.findByEmail("yao.xiao@hp.com"));
        for (Item item : items) {
            System.out.println(item.getContent());
        }
    }
}