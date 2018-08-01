package com.oocl.overwatcher.controller;

import com.oocl.overwatcher.dto.EmployeeDto;
import com.oocl.overwatcher.entities.User;
import com.oocl.overwatcher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/employees")
    public List<EmployeeDto> findAllUser(){
        List<EmployeeDto> employeeDtos=userService.findAllUser().stream().map(user -> new EmployeeDto(user)).collect(Collectors.toList());
        return employeeDtos;
    }
}
