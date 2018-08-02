package com.oocl.overwatcher.controller;

import com.oocl.overwatcher.dto.EmployeeDto;
import com.oocl.overwatcher.entities.User;
import com.oocl.overwatcher.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("/parkingBoys")
    public List<EmployeeDto> findAllParkingBoys(){
        List<User> parkingBoys = new ArrayList<>();
        roleService.findAllParkingBoys().forEach(role -> parkingBoys.addAll(role.getUsers()));
        return parkingBoys.stream().map(EmployeeDto::new).collect(Collectors.toList());
    }
}
