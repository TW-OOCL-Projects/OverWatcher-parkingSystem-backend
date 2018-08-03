package com.oocl.overwatcher.repositoriesTest;

import com.oocl.overwatcher.entities.ParkingLot;
import com.oocl.overwatcher.entities.Role;
import com.oocl.overwatcher.entities.User;
import com.oocl.overwatcher.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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
        testEntityManager.persist(new User("bale"));
        testEntityManager.persist(new User("lei"));
        //when
        List<User> userList = userRepositories.findAll();
        //then
        assertThat(userList.get(1).getId(), is(2L));
        assertThat(userList.get(1).getName(), is("bale"));

    }


    @Test
    public void findUserWithRoles() {
        //given
        Role role = new Role("manager");
        List<Role> roleList = new ArrayList<>();
        roleList.add(role);
        testEntityManager.persist(new User("bale",roleList));
        //when
        List<User> userList = userRepositories.findAll();
        //then
        assertThat(userList.get(1).getRoleList().size(),is(1));
        assertThat(userRepositories.findAll().get(1).getRoleList().get(0).getName(),is("manager"));
    }

    @Test
    public void finAllParkingLotByUser(){
        //when
        List<User> userList = userRepositories.findAll();
        //then
        assertThat(userList.get(1).getParkingLotList().size(),is(0));

    }
}
