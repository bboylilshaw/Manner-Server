package com.hp.manner.service;

import com.hp.manner.model.User;
import com.hp.manner.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@PropertySource("classpath:exception.properties")
public class UserServiceImpl implements UserService {

    @Autowired
    private Environment env;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUser(ObjectId id) {
        return userRepository.findOne(id);
    }

    @Override
    public User addUser(User user) throws Exception {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new Exception(MessageFormat.format(env.getProperty("user.exists"), user.getEmail()));
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) throws Exception {
        if (!userRepository.exists(user.getId())) {
            throw new Exception(env.getProperty("user.not.exist"));
        }
        userRepository.save(user);
        return null;
    }

    @Override
    public void deleteUser(ObjectId id) throws Exception {
        userRepository.delete(id);
    }

}
