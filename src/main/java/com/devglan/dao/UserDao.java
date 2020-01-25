package com.devglan.dao;

import com.devglan.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
