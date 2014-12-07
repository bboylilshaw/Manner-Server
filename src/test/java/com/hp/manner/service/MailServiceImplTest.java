package com.hp.manner.service;

import com.hp.manner.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class MailServiceImplTest {

    @Autowired
    MailService mailService;

    @Test
    public void testSendEmailWithTemplate() throws Exception {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("user", "Jason");
        mailService.sendEmailWithTemplate("xiaoyao8823@gmail.com", "test", modelMap);
    }
}