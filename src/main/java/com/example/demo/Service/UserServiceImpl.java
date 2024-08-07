package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.RoleRepository;
import com.example.demo.Dao.UserRepository;
import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;

import jakarta.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
//	@PostConstruct
//	public void insertUser() {
//		User user1 = new User();
//		user1.setUsername("tien");
//		user1.setPassword("$2a$12$0Scqo0Fyl/ggfJHEGnIfcOPqKPXBPgta3S7aB1fkC3tmxG3WeKxp2");
//		user1.setEnable(true);
//		Role role1 = new Role();
//		role1.setName("ROLE_ADMIN");
//		Collection<Role> roles = new ArrayList<>();
//		roles.add(role1);
//		user1.setRoles(roles);
//		userRepository.save(user1);
//	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("Invalid Username or Password");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), rolesToAuthorities(user.getRoles()));
	}
	
	// java lamda get roles
	private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		
	}
	

}
