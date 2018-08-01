package com.oocl.overwatcher.repositoriesTest;

import com.oocl.overwatcher.entities.Authority;
import com.oocl.overwatcher.entities.Role;
import com.oocl.overwatcher.repositories.AuthorityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthorityRepositoryTest {
    @Autowired
    private AuthorityRepository repository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findByRole(){
//        Role manager=new Role(1L,"manager");
//        entityManager.persist(new Authority(1L,"yggl",manager));
//        entityManager.persist(new Authority(2L,"tccgl",manager));


    }
}
