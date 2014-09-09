package com.hp.manner.service;

import com.hp.manner.exception.AppException;
import com.hp.manner.model.User;
import com.hp.manner.model.UserPasswordForm;
import com.hp.manner.model.UserProfileForm;
import org.bson.types.ObjectId;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    public List<User> listAllUsers();

    public User getUser(ObjectId id);

    public User getUserByEmail(String email);

    public User addUser(User user) throws Exception;

    public User updateUser(User user) throws Exception;

    public User updateUserProfile(UserProfileForm userProfileForm) throws AppException;

    public User updateUserPassword(UserPasswordForm userPasswordForm) throws AppException;

    public boolean validatePassword(String email, String rawPassword) throws AppException;

    public void deleteUser(ObjectId id) throws Exception;

}
