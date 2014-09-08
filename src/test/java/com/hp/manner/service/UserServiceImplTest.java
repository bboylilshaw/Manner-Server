package com.hp.manner.service;

import com.hp.manner.AbstractIntegrationTest;
import com.hp.manner.model.Role;
import com.hp.manner.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserServiceImplTest extends AbstractIntegrationTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    public void testListAllUsers() throws Exception {
        List<User> users = userService.listAllUsers();
        users.forEach(System.out::println);
    }

    @Test
    public void testGetUserByEmail() throws Exception {
        User user = userService.getUserByEmail("yao.xiao@hp.com");
        System.out.println(user);
        assertThat(user.getFirstName(), is("Yao"));
        assertThat(user.getLastName(), is("Xiao"));
        assertThat(user.getCommonName(), is("Jason"));
    }

    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setFirstName("dummy");
        user.setLastName("dummy");
        user.setCommonName("dummy");
        user.setEmail("dummy@dummy.com");
        user.setRole(Role.USER);
        User savedUser = userService.addUser(user);
        assertThat(userService.getUserByEmail("dummy@dummy.com"), is(savedUser));
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