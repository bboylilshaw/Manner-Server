package com.hp.manner.service;

import com.hp.manner.model.User;

public interface UserService {

    public User signup(User user) throws Exception;

    public User getUserByEmail(String email);
}
