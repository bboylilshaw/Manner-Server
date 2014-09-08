package com.hp.manner;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { AppConfig.class, WebMvcConfig.class })
public abstract class AbstractIntegrationTest {

    @Before
    public void initLoginUser() throws Exception{
        System.out.println("Initialize login user.");
        Authentication authentication = new UsernamePasswordAuthenticationToken("yao.xiao@hp.com", "123456");
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}
