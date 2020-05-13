package com.spardarus.entity;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {


    public static final String DEFAULT_ROLE = "ROLE_USER";

    @Override
    public String getAuthority() {
        return DEFAULT_ROLE;
    }
}
