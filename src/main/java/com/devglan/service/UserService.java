package com.devglan.service;

import com.devglan.model.AppUser;

import java.util.List;

public interface UserService {

    AppUser save(AppUser appUser);
    List<AppUser> findAll();
    void delete(long id);
    AppUser findByUsername(final String username);
}
