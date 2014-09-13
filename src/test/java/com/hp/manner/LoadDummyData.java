package com.hp.manner;

import com.hp.manner.model.*;
import com.hp.manner.repository.ItemRepository;
import com.hp.manner.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LoadDummyData extends AbstractIntegrationTest{

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void loadDummyData() throws Exception {
        System.out.println("Drop all collections.");
        mongoTemplate.dropCollection(User.class);
        mongoTemplate.dropCollection(Item.class);

        System.out.println("Load dummy users data.");
        User user1 = new User("Yao", "Xiao", "Jason Shaw", "yao.xiao@hp.com", encoder.encode("123456"), Role.ADMIN);

        Map<String, String> groups1 = new HashMap<>();
        groups1.put("BMI", "Lead");
        groups1.put("Watson", "Member");
        user1.setGroups(groups1);

        User user2 = new User("John", "Smith", "John Smith", "john@jsmith.com", encoder.encode("123456"), Role.USER);

        Map<String, String> groups2 = new HashMap<>();
        groups2.put("BMI", "Member");
        user2.setGroups(groups2);

        userRepository.save(user1);
        userRepository.save(user2);

        System.out.println("Load dummy items data.");
        User user = userRepository.findByEmail("yao.xiao@hp.com");

        Item item1 = new Item();
        item1.setContent("Learn Spring Data Mongodb");
        item1.setPriority(Priority.HIGH);
        item1.setDueDate(new Date());// or new Date(1404172800000L) 2014-07-01 00:00:00
        item1.setStatus(Status.NEW);
        item1.setPercentage(0);
        item1.setOwner(user);

        Item item2 = new Item();
        item2.setContent("Learn Spring Security");
        item2.setPriority(Priority.MEDIUM);
        item2.setDueDate(new Date()); // or new Date(1404172800000L) 2014-07-01 00:00:00
        item2.setStatus(Status.WORK_IN_PROGRESS);
        item2.setPercentage(50);
        item2.setOwner(user);

        itemRepository.save(item1);
        itemRepository.save(item2);
    }

}
