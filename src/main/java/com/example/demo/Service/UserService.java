package com.example.demo.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.Entity.User;


public interface UserService extends UserDetailsService {
	public User findByUsername(String username);
}
