package com.dian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dian.repository.UserRepository;

@Service
public class UserService {
	
	public final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepo) {
		this.userRepository = userRepo;
	}
	
	
}
