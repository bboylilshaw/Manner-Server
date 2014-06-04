package com.hp.manner.service;

import com.hp.manner.model.User;
import com.hp.manner.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User signup(User user) throws Exception {
        User checkUser = userRepository.findByEmail(user.getEmail());
        if (checkUser != null) {
            throw new Exception("User exists with email:" + user.getEmail());
        }
        return userRepository.save(user);
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findOne(new ObjectId(userId));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
