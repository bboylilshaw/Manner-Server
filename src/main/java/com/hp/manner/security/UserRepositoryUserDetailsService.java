package com.hp.manner.security;

import com.hp.manner.domain.User;
import com.hp.manner.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException("Could not find user!");
        }

        UserRepositoryUserDetails userDetails = new UserRepositoryUserDetails();
        BeanUtils.copyProperties(user, userDetails);
        userDetails.setId(user.getId());

        return userDetails;
    }

}
