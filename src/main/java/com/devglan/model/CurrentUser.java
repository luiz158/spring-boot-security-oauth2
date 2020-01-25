package com.devglan.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;


public class CurrentUser extends User {
    private final AppUser appUser;

    public CurrentUser(final AppUser appUser) {
        super(appUser.getUsername(), appUser.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")));
        this.appUser = appUser;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public String getUsername() {
        return appUser.getUsername();
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "appUser=" + appUser +
                '}';
    }
}
