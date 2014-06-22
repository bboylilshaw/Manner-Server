package com.hp.manner.service;

import com.hp.manner.model.User;
import com.hp.manner.test.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImplTest extends BaseTest {

    @Autowired
    private UserServiceImpl userService;

    @Before
    public void preTest() throws Exception {
        super.resetMongoDB();
    }

    @After
    public void postTest() throws Exception {
        super.resetMongoDB();
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
    }

    @Test
    public void testUpdateUser() throws Exception {

    }

    @Test
    public void testDeleteUser() throws Exception {

    }


}