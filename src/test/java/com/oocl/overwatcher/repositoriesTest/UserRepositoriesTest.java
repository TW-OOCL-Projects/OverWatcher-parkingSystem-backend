package com.oocl.overwatcher.repositoriesTest;

import com.oocl.overwatcher.entities.User;
import com.oocl.overwatcher.repositories.UserRepositories;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoriesTest {
    @Autowired
    private UserRepositories userRepositories;
    @Autowired
    private TestEntityManager testEntityManager;


    @Test
    public void findAll() {
        //given
        testEntityManager.persist(new User("bale","112233"));
        testEntityManager.persist(new User("lei","112233"));

        //when
        List<User> companiesList = userRepositories.findAll();

        //then
        assertThat(companiesList.size(), is(2));
        assertThat(companiesList.get(0).getId(), is(1L));
        assertThat(companiesList.get(0).getUserName(), is("bale"));
        assertThat(companiesList.get(0).getPassword(), is("112233"));

    }
}
