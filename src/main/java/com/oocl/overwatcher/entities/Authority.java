package com.oocl.overwatcher.entities;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    @Ignore
    @ManyToOne
    private Role role;

    public Authority() {
    }

    public Authority(Long id,String comment){
        this(id,comment,null);
    }

    public Authority(Long id, String comment, Role role) {
        this.id=id;
        this.comment=comment;
        this.role=role;
    }

    public Authority(String comment) {
        this.comment=comment;
    }

    public Authority(String comment, Role role) {
        this.comment=comment;
        this.role=role;
    }

    @Override
    public String getAuthority() {
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
