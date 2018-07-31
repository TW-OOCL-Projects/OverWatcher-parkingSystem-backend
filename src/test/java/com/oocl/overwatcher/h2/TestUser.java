package com.oocl.overwatcher.h2;

import com.oocl.overwatcher.security.domain.SysUser;
import com.oocl.overwatcher.security.repository.SysUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

@DataJpaTest
@RunWith(SpringRunner.class)
public class TestUser {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SysUserRepository repository;


    @Test
    public void should_return_a_user_when_call_find_one(){
        SysUser user = new SysUser();
        user.setUsername("tom");
        user.setPassword("123");
        entityManager.persistAndFlush(user);
        SysUser sysUser = repository.findById(1L).get();
        Assert.assertThat(sysUser.getUsername(),equalTo("tom"));
    }
}
