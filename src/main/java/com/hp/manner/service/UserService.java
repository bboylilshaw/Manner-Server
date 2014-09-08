package com.hp.manner.service;

import com.hp.manner.model.User;
import com.hp.manner.model.UserProfile;
import org.bson.types.ObjectId;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    public List<User> listAllUsers();

    public User getUser(ObjectId id);

    public User getUserByEmail(String email);

    public User addUser(User user) throws Exception;

    public User updateUser(User user) throws Exception;

    public User updateUserProfile(String email, UserProfile userProfile) throws Exception;

    public User updateUserPassword(String email, String oldPassword, String newPassword) throws Exception;

    public void deleteUser(ObjectId id) throws Exception;

}
