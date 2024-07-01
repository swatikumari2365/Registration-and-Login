package com.swati.LoginPage.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.swati.LoginPage.model.User;
import com.swati.LoginPage.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto );

	 
}
 