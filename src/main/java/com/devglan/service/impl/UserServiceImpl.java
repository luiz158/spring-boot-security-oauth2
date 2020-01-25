package com.devglan.service.impl;

import com.devglan.dao.UserDao;
import com.devglan.model.AppUser;
import com.devglan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
	
	private final UserDao userDao;

	public UserServiceImpl(@Autowired final UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<AppUser> findAll() {
		List<AppUser> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		userDao.delete(id);
	}

	@Override
    public AppUser save(AppUser appUser) {
        return userDao.save(appUser);
    }

	@Override
	public AppUser findByUsername(final String username) {
		System.out.println("POBIERANIE DLA " + username);
		final AppUser res = userDao.findByUsername(username);
		System.out.println(res);
		return res;
	}

	//    @PostConstruct
//	public void setup(){
//		User user = new User();
//		user.setUsername("admin@admin.pl");
//		user.setPassword("admin");
//		user.setAge(25);
//		user.setSalary(1300);
//		save(user);
//	}
}
