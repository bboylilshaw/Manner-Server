package com.hp.manner.repository;

import com.hp.manner.AbstractIntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testFindByEmail() throws Exception {
        assertThat(userRepository.findByEmail("yao.xiao@hp.com").getFirstName(), is("Yao"));
        assertThat(userRepository.findByEmail("yao.xiao@hp.com").getLastName(), is("Xiao"));
    }
}