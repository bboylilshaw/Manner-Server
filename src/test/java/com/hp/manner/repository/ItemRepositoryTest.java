package com.hp.manner.repository;

import com.hp.manner.Application;
import com.hp.manner.common.Priority;
import com.hp.manner.common.Status;
import com.hp.manner.domain.Group;
import com.hp.manner.domain.Item;
import com.hp.manner.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void testSave() throws Exception {
//        User user = userRepository.getOne(1L);
//        Group group = new Group();
//
////        Item item = Item.of("1", user, user, new Date(), user, new Date(), group, Status.NEW, 0, new Date(), Priority.HIGH, "remarks");
//
//        itemRepository.save(item);
    }
}