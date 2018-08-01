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
    public ResponseEntity<List<EmployeeDto>> findAllUser(){
        List<EmployeeDto> employeeDtos=userService.findAllUser().stream().map(user -> new EmployeeDto(user)).collect(Collectors.toList());
        return ResponseEntity.ok(employeeDtos);
    }

    @PostMapping("/employees")
    public ResponseEntity addUser(@RequestBody User user){
        if (userService.addUser(user)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/employees/status")
    public ResponseEntity<Void> updateUserStatus(@RequestBody User user) {
        if (StringUtils.isNotBlank(user.getStatus()) && StringUtils.isNotBlank(user.getId() + "")) {
            if(userService.updateStatus(user)){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @GetMapping("/employees/{id}")
    @PreAuthorize("hasAnyAuthority('admin')")
    public ResponseEntity<EmployeeDto> findOne(@PathVariable("id") Long id) {
        try {
            User user = userService.findOne(id).orElseThrow(() -> new Exception("找不到该用户"));
            return ResponseEntity.ok(new EmployeeDto(user));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
