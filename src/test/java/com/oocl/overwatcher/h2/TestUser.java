package com.oocl.overwatcher.h2;

import com.oocl.overwatcher.entities.User;
import com.oocl.overwatcher.repositories.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class TestUser {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void should_return_a_user_when_call_find_one(){
        User user = new User();
        user.setUsername("leo");
        user.setPassword("123");
        entityManager.persistAndFlush(user);
        User u = userRepository.findById(1).get();
        Assertions.assertThat(u.getUsername().equals("leo"));

    }
}
