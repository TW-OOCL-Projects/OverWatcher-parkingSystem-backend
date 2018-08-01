package com.oocl.overwatcher.entities;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
    private Long id;
    private String comment;
    @Override
    public String getAuthority() {
        return null;
    }
}
