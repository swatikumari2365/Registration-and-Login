package com.swati.LoginPage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.swati.LoginPage"})
public class LoginPageApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginPageApplication.class, args);
	}

}
