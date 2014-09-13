package com.hp.manner;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { AppConfig.class, WebMvcConfig.class })
public abstract class AbstractIntegrationTest {

    @Before
    public void initLoginUser() throws Exception{
        System.out.println("Initialize authentication");
        List< GrantedAuthority > authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority("ROLE_SUPER_ADMIN"));
        authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        Authentication authentication = new UsernamePasswordAuthenticationToken("Super Admin", "123456", authList);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}
