package com.example.demo.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
public class RestLogin {
	@Autowired
	private UserService userService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/authenticate/{username}/{password}")
	public boolean getUser(@PathVariable("username") String username, @PathVariable("password") String password) {
		User user = userService.findByUsername(username);
	   if(user == null) {
		   return false;
	   }
	   String ps = user.getPassword();
	   if(ps.equals(bCryptPasswordEncoder.encode(password))) {
		   return true;
	   }
	   return false;
	}
	
	
}
