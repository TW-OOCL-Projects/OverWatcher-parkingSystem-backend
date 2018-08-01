package com.oocl.overwatcher.repositoriesTest;

import com.oocl.overwatcher.entities.Authority;
import com.oocl.overwatcher.entities.Role;
import com.oocl.overwatcher.repositories.RoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleRepositoryTest {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private TestEntityManager testEntityManager;
    @Test
    public void findAll(){
        //given
        List<Authority> authorities=new ArrayList<>();
        authorities.add(new Authority("yggl"));
        authorities.add(new Authority("tccgl"));

        testEntityManager.persist(new Role("manger",authorities));
        //when
        List<Role> roleList = roleRepository.findAll();
        assertThat(roleList.get(0).getName(), is("manger"));
        assertThat(roleList.get(0).getAuthorityList().size(), is(2));
        assertThat(roleList.get(0).getAuthorityList().get(0).getComment(), equalTo("yggl"));
        assertThat(roleList.get(0).getAuthorityList().get(1).getComment(), equalTo("tccgl"));

    }


}
