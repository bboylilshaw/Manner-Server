package com.hp.manner;

import com.hp.manner.domain.Group;
import com.hp.manner.domain.Item;
import com.hp.manner.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
* Created by Jason on 12/8/14.
*/
@Configuration
public class SpringDataRestConfig extends RepositoryRestMvcConfiguration {

    @Autowired
    private Environment env;

    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Item.class, Group.class, User.class);
        config.setBaseUri(env.getProperty("spring.data.rest.baseUri"));
        super.configureRepositoryRestConfiguration(config);
    }

}
