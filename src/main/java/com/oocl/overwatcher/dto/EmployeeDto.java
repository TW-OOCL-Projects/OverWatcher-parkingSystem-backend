package com.oocl.overwatcher.dto;

import com.oocl.overwatcher.entities.Role;
import com.oocl.overwatcher.entities.User;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDto {
    private Long id;
    private String name;
    private String status;
    private List<String> roleList;
    private String email;
    private String phone;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public List<String> getRoleList() {
        return roleList;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public EmployeeDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.status = user.getStatus();
        this.roleList = user.getRoleList().stream().map(role -> role.getName()).collect(Collectors.toList());
        this.email = user.getEmail();
        this.phone = user.getPhone();
    }
}
