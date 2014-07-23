package com.hp.manner.test;


import com.hp.manner.config.AppConfig;
import com.hp.manner.config.WebMvcConfig;
import com.hp.manner.config.WebSecurityConfig;
import com.hp.manner.model.Item;
import com.hp.manner.model.User;
import com.hp.manner.repository.ItemRepository;
import com.hp.manner.repository.UserRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, WebMvcConfig.class, WebSecurityConfig.class})
public class BaseTest {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public void resetMongoDB() {
        userRepository.deleteAll();
        itemRepository.deleteAll();

        User user1 = new User();
        user1.setFirstName("Yao");
        user1.setLastName("Xiao");
        user1.setEmail("yao.xiao@hp.com");
        user1.setCommonName("Jason");
        user1.setPassword(encoder.encode("123456"));

        Set<String> groups1 = new HashSet<>();
        groups1.add("BMI");
        groups1.add("Admin");
        user1.setGroup(groups1);

        User user2 = new User();
        user2.setFirstName("John");
        user2.setLastName("Smith");
        user2.setEmail("john.smith@example.com");
        user2.setCommonName("John");
        user2.setPassword(encoder.encode("123456"));

        Set<String> groups2 = new HashSet<>();
        groups2.add("BMI");
        user2.setGroup(groups2);

        userRepository.save(user1);
        userRepository.save(user2);

        User user = userRepository.findByEmail("yao.xiao@hp.com");

        Item item1 = new Item();
        item1.setContent("Learn Spring Data Mongodb");
        item1.setPriority(Item.Priority.HIGH);
        item1.setDueDate(new Date());
        item1.setStatus(Item.Status.NEW);
        item1.setPercentage(0);
        item1.setOwner(user);

        Item item2 = new Item();
        item2.setContent("Learn Spring Security");
        item2.setPriority(Item.Priority.MEDIUM);
        item2.setDueDate(new Date());
        item2.setStatus(Item.Status.WORK_IN_PROGRESS);
        item2.setPercentage(50);
        item2.setOwner(user);

        itemRepository.save(item1);
        itemRepository.save(item2);
    }

}
