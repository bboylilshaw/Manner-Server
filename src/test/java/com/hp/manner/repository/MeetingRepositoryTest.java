package com.hp.manner.repository;

import com.hp.manner.config.AppConfig;
import com.hp.manner.config.MongodbConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, MongodbConfig.class})
public class MeetingRepositoryTest {

    @Autowired
    private MeetingRepository meetingRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() throws Exception {
    }

}