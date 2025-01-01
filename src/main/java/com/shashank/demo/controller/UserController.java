package com.shashank.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.shashank.demo.entity.UserDetail;
import com.shashank.demo.entity.UserRole;
import com.shashank.demo.service.MailService;
import com.shashank.demo.service.UserDetailService;

@Controller
public class UserController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired
	private MailService mailService;
	
	@GetMapping("/signup")
	public String userSignup() {
		return "register";
	}
	
	@PostMapping("/signup")
	public String signupUser(@ModelAttribute UserDetail userDetail) {
		userDetail.setPassword(passwordEncoder.encode(userDetail.getPassword()));
		UserRole userRole= new UserRole();
		if(userDetail.getAuthority().equals("admin")) {
			userRole.setRole("ROLE_ADMIN");//set required value of role for admin
			userDetail.setEnable("0");// disable user
		}else {
			userRole.setRole("ROLE_USER");//set required value of role for admin
			userDetail.setEnable("1");// disable user
		}
		
		//to make relations/associations work we have to set userDetail to userRole and vice versa
		userDetail.setUserRole(userRole);
		userRole.setUserDetail(userDetail);
		
		//save userDetail through user Detail Service component
		userDetailService.saveUserDetail(userDetail);
		
		//send user a confirmation mail about registration process
		String message="Thank you for joining our service. Happy shopping experience!!";
		String subject="User registratoin confirmation";
		mailService.sendMail(userDetail.getEmail(),subject,message);
		return "redirect:/login";
	}
	
	@GetMapping("/welcome")
	public String welcomeUser(Principal p) {
		UserDetail ud= userDetailService.getUserDetailByUsername(p.getName());
		
		if(ud.getUserRole().getRole().contains("ROLE_ADMIN")) {
			return "redirect:/admin/home";
		}
		else if(ud.getUserRole().getRole().contains("ROLE_USER")) {
			return "redirect:/products";
		}
		else {
			return "welcome";
		}
	}
	@GetMapping("/login")
	public String userLogin() {
		return "login";
	}
	
	/*
	 * @GetMapping("/logout") public String userLogout(Authentication auth) { return
	 * "logoin"; }
	 */
}
