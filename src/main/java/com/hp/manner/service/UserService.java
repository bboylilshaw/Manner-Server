package com.hp.manner.service;

import com.hp.manner.model.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserService {

    public List<User> listAllUsers();

    public User getUser(ObjectId id);

    public User getUserByEmail(String email);

    public User addUser(User user) throws Exception;

    public User updateUser(User user) throws Exception;

    public User updateUserProfile(User user) throws Exception;

    public User updateUserPassword(String email, String oldPassword, String newPassword) throws Exception;

    public void deleteUser(ObjectId id) throws Exception;

}
