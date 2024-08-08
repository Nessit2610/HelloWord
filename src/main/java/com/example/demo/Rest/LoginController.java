package com.example.demo.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;



@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String showLoginPage(){
        return "login";
    }
	
	@GetMapping("/authenticate/{username}")
	public String getUser(@PathVariable("username") String username) {
		User user = userService.findByUsername(username);
	   if(user == null) {
		   return "Not found !";
	   }
		return user.getPassword();
	}
	
	
  
}


