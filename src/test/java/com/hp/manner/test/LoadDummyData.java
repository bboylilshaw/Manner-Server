package com.hp.manner.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class LoadDummyData extends BaseTest{

    @Before
    public void setUp() throws Exception{
        Authentication authentication = new UsernamePasswordAuthenticationToken("yao.xiao@hp.com", "123456");
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Test
    public void loadDummyData() throws Exception {
        super.resetMongoDB();
    }

}
