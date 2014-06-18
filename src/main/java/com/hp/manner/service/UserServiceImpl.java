package com.hp.manner.service;

import com.hp.manner.model.User;
import com.hp.manner.repository.UserRepository;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.UUID;

@Service
@PropertySource("classpath:exception.properties")
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private Environment env;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public List<User> listAllUsers() {
        logger.info("list all users");
        return userRepository.findAll();
    }

    @Override
    public User getUser(ObjectId id) {
        logger.info("get user by ObjectId: " + id.toString());
        return userRepository.findOne(id);
    }

    @Override
    public User getUserByEmail(String email) {
        logger.info("get user by Email: " + email);
        return userRepository.findByEmail(email);
    }

    @Override
    public User addUser(User user) throws Exception {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new Exception(MessageFormat.format(env.getProperty("user.exists"), user.getEmail()));
        }

        String tempPassword = UUID.randomUUID().toString().substring(0,8);
        logger.info("temp password is: " + tempPassword);
        user.setPassword(encoder.encode(tempPassword));

        logger.info("add " + user);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) throws Exception {
        if (!userRepository.exists(user.getId())) {
            throw new Exception(env.getProperty("user.not.exist"));
        }
        logger.info("update " + user);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(ObjectId id) throws Exception {
        if (!userRepository.exists(id)) {
            throw new Exception(env.getProperty("user.not.exist"));
        }
        logger.info("delete user by ObjectId:" + id.toString());
        userRepository.delete(id);
    }

}
