package com.oocl.overwatcher.controller;

import com.oocl.overwatcher.dto.RoleDTO;
import com.oocl.overwatcher.entities.Role;
import com.oocl.overwatcher.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.events.Characters;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("/parkingBoys")
    public List<RoleDTO> findAllParkingBoys(){
        return roleService.findAllParkingBoys().stream().map(RoleDTO::new).collect(Collectors.toList());
    }
}
