package com.hp.manner.testdata;

import com.hp.manner.config.AppConfig;
import com.hp.manner.model.User;
import com.hp.manner.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppConfig.class)
public class LoadUserData {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        userRepository.deleteAll();
    }

    @Test
    public void loadUserData() throws Exception {
        User user1 = new User();
        user1.setFirstName("Yao");
        user1.setLastName("Xiao");
        user1.setEmail("yao.xiao@hp.com");
        user1.setCommonName("Jason");
        user1.setPassword("123456");
        Set<String> groups1 = new HashSet<String>();
        groups1.add("BMI");
        groups1.add("Admin");
        user1.setGroup(groups1);

        User user2 = new User();
        user2.setFirstName("John");
        user2.setLastName("Smith");
        user2.setEmail("jsmith@example.com");
        user2.setCommonName("John");
        user2.setPassword("123456");
        Set<String> groups2 = new HashSet<String>();
        groups2.add("BMI");
        user2.setGroup(groups2);

        userRepository.save(user1);
        userRepository.save(user2);
    }
}