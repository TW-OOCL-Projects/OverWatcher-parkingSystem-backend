package com.oocl.overwatcher.service;


import com.oocl.overwatcher.entities.User;
import com.oocl.overwatcher.repositories.UserRepository;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {


    @Test
    public void should_get_all_user(){
        UserRepository repository=mock(UserRepository.class);
        UserService service=new UserService(repository);
        List<User> users= new ArrayList<>(Arrays.asList(new User("Jason"),new User("java")));
        when(repository.findAll()).thenReturn(users);
        //when
        List<User> result= service.findAllUser();

        //then
        assertThat(result.size(), is(2));
        assertThat(result.get(0).getName(), is("Jason"));
        assertThat(result.get(1).getName(), is("java"));
    }
}
