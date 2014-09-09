package com.hp.manner.service;

import com.hp.manner.exception.AppException;
import com.hp.manner.exception.UserExistsException;
import com.hp.manner.model.Role;
import com.hp.manner.model.User;
import com.hp.manner.model.UserPasswordForm;
import com.hp.manner.model.UserProfileForm;
import com.hp.manner.repository.UserRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@PropertySource("classpath:exception.properties")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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
        logger.info("get user by ObjectId: {}", id.toString());
        return userRepository.findOne(id);
    }

    @Override
    public User getUserByEmail(String email) {
        logger.info("get user by Email: " + email);
        return userRepository.findByEmail(email);
    }

    @Override
    public User addUser(User user) throws UserExistsException {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new UserExistsException(MessageFormat.format(env.getProperty("user.exists"), user.getEmail()));
        }
        if (user.getPassword() == null) {
            String tempPassword = UUID.randomUUID().toString().substring(0,8);
            logger.info("temp password is: " + tempPassword);
            user.setPassword(encoder.encode(tempPassword));
        }
        logger.info("add new user: " + user);
        return userRepository.save(user);
    }

    //TODO: Implement updateUser function
    @Override
    public User updateUser(User user) throws Exception {
        return null;
    }

    @Override
    public User updateUserProfile(UserProfileForm userProfileForm) throws AppException {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User userToUpdate = userRepository.findByEmail(email);
        if (userToUpdate == null) {
            throw new AppException(MessageFormat.format(env.getProperty("user.not.found"), email));
        }
        logger.info("original user is: " + userToUpdate);
        BeanUtils.copyProperties(userProfileForm, userToUpdate);
        logger.info("updated to " + userToUpdate);
        return userRepository.save(userToUpdate);
    }

    @Override
    public User updateUserPassword(UserPasswordForm userPasswordForm) throws AppException{
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new AppException(MessageFormat.format(env.getProperty("user.not.found"), email));
        }
        user.setPassword(encoder.encode(userPasswordForm.getNewPassword()));
        logger.info("update user password");
        return userRepository.save(user);
    }

    @Override
    public boolean validatePassword(String email, String rawPassword) throws AppException{
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new AppException(MessageFormat.format(env.getProperty("user.not.found"), email));
        }
        return encoder.matches(rawPassword, user.getPassword());
    }

    @Override
    public void deleteUser(ObjectId id) throws Exception {
        if (!userRepository.exists(id)) {
            throw new AppException(env.getProperty("user.not.found"));
        }
        logger.info("delete user by ObjectId: " + id.toString());
        userRepository.delete(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException(MessageFormat.format(env.getProperty("user.not.found"), email));
        }

        final boolean enabled = true;
        final boolean accountNonExpired = true;
        final boolean credentialsNonExpired = true;
        final boolean accountNonLocked = true;

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(user.getRole()));
    }

    private List<GrantedAuthority> getAuthorities(Role role) {
        List<GrantedAuthority> authList = new ArrayList<>();
        if (role.equals(Role.SUPER_ADMIN)) {
            authList.add(new SimpleGrantedAuthority("ROLE_SUPER_ADMIN"));
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else if (role.equals(Role.ADMIN)) {
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else if (role.equals(Role.USER)) {
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authList;
    }

}
