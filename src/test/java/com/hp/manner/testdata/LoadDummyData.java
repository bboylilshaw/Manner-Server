package com.hp.manner.testdata;

import com.hp.manner.config.AppConfig;
import com.hp.manner.model.Item;
import com.hp.manner.model.User;
import com.hp.manner.repository.ItemRepository;
import com.hp.manner.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
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
@ContextConfiguration(classes = AppConfig.class)
public class LoadDummyData {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        userRepository.deleteAll();
        itemRepository.deleteAll();
    }

    @Test
    public void loadDummyData() throws Exception {
        userRepository.deleteAll();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        User user1 = new User();
        user1.setFirstName("Yao");
        user1.setLastName("Xiao");
        user1.setEmail("yao.xiao@hp.com");
        user1.setCommonName("Jason");
        user1.setPassword(encoder.encode("123456"));

        Set<String> groups1 = new HashSet<String>();
        groups1.add("BMI");
        groups1.add("Admin");
        user1.setGroup(groups1);

        User user2 = new User();
        user2.setFirstName("John");
        user2.setLastName("Smith");
        user2.setEmail("john.smith@example.com");
        user2.setCommonName("John");
        user2.setPassword(encoder.encode("123456"));
        Set<String> groups2 = new HashSet<String>();
        groups2.add("BMI");
        user2.setGroup(groups2);

        userRepository.save(user1);
        userRepository.save(user2);

        User user = userRepository.findByEmail("yao.xiao@hp.com");

        Item item1 = new Item();
        item1.setContent("Learn Spring Data Mongodb");
        item1.setPriority("High");
        item1.setDueDate(new Date());
        item1.setStatus("50%");
        item1.setOwner(user);

        Item item2 = new Item();
        item2.setContent("Learn Spring Security");
        item2.setPriority("Medium");
        item2.setDueDate(new Date());
        item2.setStatus("40%");
        item2.setOwner(user);

        itemRepository.save(item1);
        itemRepository.save(item2);
    }

}
