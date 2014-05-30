package com.hp.manner.repository;

import com.hp.manner.config.MongodbConfig;
import com.hp.manner.model.ActionItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MongodbConfig.class})
public class ActionItemRepositoryTest {

    @Autowired
    private MongoOperations mOps;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void test() throws Exception {
        //ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        //MongoOperations mOps = ctx.getBean("MongoTemplate", MongoOperations.class);
        ActionItem actionItem = new ActionItem();
        actionItem.setId(UUID.randomUUID().toString());
        actionItem.setContent("Learn Mongodb");
        actionItem.setOwner("Jason");
        actionItem.setStatus("50%");
        actionItem.setDueDate(new Date());
        mOps.insert(actionItem);
    }

}