package com.hp.manner.security;


import com.hp.manner.common.Role;
import com.hp.manner.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserRepositoryUserDetails extends User implements UserDetails {


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authList = new ArrayList<>();
        if (super.getRole().equals(Role.SUPER_ADMIN)) {
            authList = AuthorityUtils.createAuthorityList("ROLE_SUPER_ADMIN", "ROLE_SUPER_ADMIN", "ROLE_USER");
        } else if (super.getRole().equals(Role.ADMIN)) {
            authList = AuthorityUtils.createAuthorityList("ROLE_SUPER_ADMIN", "ROLE_USER");
        } else if (super.getRole().equals(Role.USER)) {
            authList = AuthorityUtils.createAuthorityList("ROLE_USER");
        }
        return authList;
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    protected void setId(Long id) {
        super.setId(id);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
