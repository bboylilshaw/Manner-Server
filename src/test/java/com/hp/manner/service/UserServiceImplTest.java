package com.hp.manner.service;

import com.hp.manner.model.User;
import com.hp.manner.test.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImplTest extends BaseTest {

    @Autowired
    private UserServiceImpl userService;

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testListAllUsers() throws Exception {
        List<User> users = userService.listAllUsers();
        users.forEach(System.out::println);
    }

    @Test
    public void testGetUserByEmail() throws Exception {
        User user = userService.getUserByEmail("yao.xiao@hp.com");
        System.out.println(user);
        Assert.assertEquals("Jason", user.getCommonName());
    }

    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setFirstName("dummy");
        user.setLastName("dummy");
        user.setCommonName("dummy");
        user.setEmail("dummy@dummy.com");
        user.setRole(User.Role.USER);
        userService.addUser(user);
    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = userService.getUserByEmail("dummy@dummy.com");
        System.out.println(user);
        user.setFirstName("dummy1");
        System.out.println(user);
        userService.updateUser(user);
    }

    @Test
    public void testDeleteUser() throws Exception {
        User user = userService.getUserByEmail("dummy@dummy.com");
        System.out.println(user);
        userService.deleteUser(user.getId());
        Assert.assertEquals(null, userService.getUserByEmail("dummy@dummy.com"));
    }


}