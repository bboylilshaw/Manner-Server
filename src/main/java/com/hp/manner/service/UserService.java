package com.hp.manner.service;

import com.hp.manner.model.User;
import com.hp.manner.model.UserPasswordForm;
import com.hp.manner.model.UserProfileForm;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserService  {

    List<User> listAllUsers();

    User getUser(ObjectId id);

    User getUserByEmail(String email);

    User addUser(User user);

    User updateUser(User user);

    User updateUserProfile(UserProfileForm userProfileForm);

    User updateUserPassword(UserPasswordForm userPasswordForm);

    boolean validatePassword(String email, String rawPassword);

    void deleteUser(ObjectId id);

}
