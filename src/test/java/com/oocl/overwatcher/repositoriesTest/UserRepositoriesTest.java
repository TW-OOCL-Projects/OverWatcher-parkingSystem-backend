package com.oocl.overwatcher.repositoriesTest;

import com.oocl.overwatcher.entities.Role;
import com.oocl.overwatcher.entities.User;
import com.oocl.overwatcher.repositories.UserRepository;
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
    private UserRepository userRepositories;
    @Autowired
    private TestEntityManager testEntityManager;


    @Test
    public void findAllBasicUser() {
        //given
        Role role = new Role("manger");
        testEntityManager.persist(new User("bale","冻结",role,"544097676@qq.com","112233"));
        testEntityManager.persist(new User("lei","冻结",role,"5455588565@qq.com","112233"));
        //when
        List<User> userList = userRepositories.findAll();
        //then
        assertThat(userList.get(1).getId(), is(2L));
        assertThat(userList.get(1).getName(), is("bale"));
        assertThat(userList.get(1).getPhone(), is("112233"));
        assertThat(userList.get(1).getRole().getId(), is(1L));

    }
    @Test
    public void addUser() {
        //given
        Role role = new Role("manger");
        User user = new User("bale","冻结",role,"544097676@qq.com","112233");
        //when
        userRepositories.save(user);
        //then
        assertThat(userRepositories.findAll().get(1).getName(),is("bale"));
        assertThat(userRepositories.findAll().get(1).getId(),is(2L));
        assertThat(userRepositories.findAll().get(1).getStatus(),is("冻结"));
        assertThat(userRepositories.findAll().get(1).getEmail(),is("544097676@qq.com"));
        assertThat(userRepositories.findAll().get(1).getPhone(),is("112233"));
    }
}
