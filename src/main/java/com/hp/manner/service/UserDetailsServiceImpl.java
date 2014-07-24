package com.hp.manner.service;

import com.hp.manner.model.User;
import com.hp.manner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final boolean enabled = true;
        final boolean accountNonExpired = true;
        final boolean credentialsNonExpired = true;
        final boolean accountNonLocked = true;

        User user = userRepository.findByEmail(email);

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(user.getRole()));
    }

    public List<GrantedAuthority> getAuthorities(User.Role role) {
        List<GrantedAuthority> authList = new ArrayList<>();
        //GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
        if (role.equals(User.Role.SUPERADMIN)) {
            authList.add(new SimpleGrantedAuthority("ROLE_SUPERADMIN"));
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else if (role.equals(User.Role.ADMIN)) {
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else if (role.equals(User.Role.USER)) {
            authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authList;
    }

}
