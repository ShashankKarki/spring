package com.shashank.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class OnlineCommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCommerceApplication.class, args);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		
		PasswordEncoder encoder= new BCryptPasswordEncoder(); // secure SAH one-way encription algorithm
		System.out.println(encoder.encode("admin123"));
		return encoder;
	}
}
