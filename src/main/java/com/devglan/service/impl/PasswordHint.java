package com.devglan.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordHint {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void printEndocedPassword() {
		System.out.println("endoced password: " + passwordEncoder.encode("password"));
	}
	
}
