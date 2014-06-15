package com.hp.manner.service;

import com.hp.manner.config.AppConfig;
import com.hp.manner.config.WebMvcConfig;
import com.hp.manner.model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, WebMvcConfig.class})
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Before
    public void preTest() throws Exception {

    }

    @After
    public void postTest() throws Exception {
        User user = userService.getUserByEmail("dummy@dummy.com");
        if (user != null){
            userService.deleteUser(user.getId());
        }

    }

    @Test
    public void testListAllUsers() throws Exception {

    }

    @Test
    public void testGetUserByEmail() throws Exception {
        User user = userService.getUserByEmail("yao.xiao@hp.com");
        Assert.assertEquals("Jason", user.getCommonName());
    }

    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setFirstName("DummyFirstName");
        user.setLastName("DummyLastName");
        user.setCommonName("DummyCommonName");
        user.setEmail("dummy@dummy.com");
        userService.addUser(user);
        // since Spring MongoDB doesn't support transaction, rollback this adding operation in @After method
    }

    @Test
    public void testUpdateUser() throws Exception {

    }

    @Test
    public void testDeleteUser() throws Exception {

    }


}