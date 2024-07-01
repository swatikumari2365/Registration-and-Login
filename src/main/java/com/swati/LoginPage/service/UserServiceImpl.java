package com.swati.LoginPage.service;


import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.swati.LoginPage.model.Role;
import com.swati.LoginPage.model.User;
import com.swati.LoginPage.repository.UserRepository;
import com.swati.LoginPage.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    public UserServiceImpl(UserRepository userRepository,@Lazy PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}


	
    
	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user=new User(registrationDto.getFirstName(),
				registrationDto.getLastName(),passwordEncoder.encode(registrationDto.getPassword()),Arrays.asList(new Role("ROLE_USER")),registrationDto.getEmail());
		return userRepository.save(user);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		
	}

}
