package com.isilona.restapi.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public final class HostmanagerUser extends User {

    private long id;

    public HostmanagerUser(final String name, final String password, final List<GrantedAuthority> auths, final long userId) {
        super(name, password, auths);

        id = userId;
    }

    // API

    public final long getId() {
        return id;
    }

    public final void setId(final long id) {
        this.id = id;
    }

}
