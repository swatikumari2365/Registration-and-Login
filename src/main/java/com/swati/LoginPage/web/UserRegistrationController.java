package com.swati.LoginPage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.swati.LoginPage.service.UserService;
import com.swati.LoginPage.web.dto.UserRegistrationDto;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	
	@GetMapping
	public String showRegistrationform() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user")UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}

}
