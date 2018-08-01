package com.oocl.overwatcher.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private List<Authority> authorityList = new ArrayList<>();
    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Role( String name,List<Authority> authorityList) {
        this(name);
        this.authorityList=authorityList;
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

    public List<Authority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<Authority> authorityList) {
        this.authorityList = authorityList;
    }
}
