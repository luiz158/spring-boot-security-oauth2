package com.devglan.service.impl;

import com.devglan.model.AppUser;
import com.devglan.model.CurrentUser;
import com.devglan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public MyUserDetailsService(@Autowired final UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(final String s) throws UsernameNotFoundException {
        System.out.println("POBIERANIE Z USERNAME " + s);
        AppUser appUser = userService.findByUsername(s);
        if (appUser == null) {
            System.out.println("APP USER NULLOWY !!!!");
            throw new UsernameNotFoundException(String.format("User with name: %s already exists", s));
        }
        final CurrentUser currentUser = new CurrentUser(appUser);
        System.out.println(currentUser);
        return currentUser;
    }
}
