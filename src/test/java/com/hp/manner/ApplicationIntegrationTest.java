package com.hp.manner;

import com.hp.manner.model.Item;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.support.Repositories;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class ApplicationIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void initializesRootApplicationContext() {
        Repositories repositories = new Repositories(context);
        assertThat(repositories.getRepositoryFor(Item.class), is(notNullValue()));
    }

}
