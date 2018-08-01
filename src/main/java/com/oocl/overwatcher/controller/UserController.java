package com.oocl.overwatcher.controller;

import com.oocl.overwatcher.dto.EmployeeDto;
import com.oocl.overwatcher.entities.User;
import com.oocl.overwatcher.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/employees")
    public ResponseEntity addUser(@RequestBody User user){
        try{
            userService.addUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping("/employees/status")
    public ResponseEntity<Void> updateUserStatus(@RequestBody User user) {
        if (StringUtils.isNotBlank(user.getStatus()) && StringUtils.isNotBlank(user.getId() + "")) {
            userService.updateStatus(user);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
