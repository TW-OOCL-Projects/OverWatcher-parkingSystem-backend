package com.oocl.overwatcher.repositoriesTest;

import com.oocl.overwatcher.entities.Authority;
import com.oocl.overwatcher.entities.Role;
import com.oocl.overwatcher.entities.User;
import com.oocl.overwatcher.repositories.AuthorityRepository;
import com.oocl.overwatcher.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthorityRepositoryTest {
    @Autowired
    private AuthorityRepository repository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void should_get_all_authrities(){
        entityManager.persist(new Authority("yggl"));
        entityManager.persist(new Authority("tccgl"));

        List<Authority> actual=repository.findAll();

        assertThat(actual.size(),equalTo(2));
        assertThat(actual.get(0).getComment(),equalTo("yggl"));
        assertThat(actual.get(1).getComment(),equalTo("tccgl"));
    }

    @Test
    public void should_get_all_authrities_by_role_id(){
        Role role1=new Role(1L,"manager");
        Role role2=new Role(2L,"employee");

        entityManager.persist(new Authority("yggl",role1));
        entityManager.persist(new Authority("tccgl",role1));
        entityManager.persist(new Authority("tccgl",role2));


        List<Authority> actual=repository.findByRoleId(1L);

        assertThat(actual.size(),equalTo(2));
        assertThat(actual.get(0).getComment(),equalTo("yggl"));
        assertThat(actual.get(1).getComment(),equalTo("tccgl"));
    }
}
