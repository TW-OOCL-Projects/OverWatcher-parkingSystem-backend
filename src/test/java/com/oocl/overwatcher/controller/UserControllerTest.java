package com.oocl.overwatcher.controller;

import com.oocl.overwatcher.dto.EmployeeDto;
import com.oocl.overwatcher.entities.User;
import com.oocl.overwatcher.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void should_get_all_employee_info_call_employees() throws Exception {
        //given
//        EmployeeDto emp1= new EmployeeDto( "Jason");
//        EmployeeDto emp2= new EmployeeDto( "Zhong");
//        List<EmployeeDto> employeeDtoList= Arrays.asList(emp1,emp2);

//        User user1= new User( "Jason");
//        User user2= new User( "Zhong");
//
//        List<User> userList= Arrays.asList(user1,user2);
//
//        when(userService.findAllUser()).thenReturn(userList);
//        //when
//        ResultActions result = mockMvc.perform(get("/orders"));
//
//        //then
//        result.andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].content.name", is("Jason")))
//                .andExpect(jsonPath("$[1].content.name", is("Zhong")));

    }
}
