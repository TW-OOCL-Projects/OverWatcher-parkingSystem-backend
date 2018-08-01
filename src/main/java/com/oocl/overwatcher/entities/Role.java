package com.oocl.overwatcher.entities;

import java.util.ArrayList;
import java.util.List;

public class Role {
    private Long id;
    private String name;
    private List<Role> roleList = new ArrayList<>();
    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
