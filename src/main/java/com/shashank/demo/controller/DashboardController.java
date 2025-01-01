package com.shashank.demo.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class DashboardController {
	@GetMapping("/admin/home")
	public String openDashboard(Principal p, Model model) {
		model.addAttribute("user",p.getName());
		return "dashboard";
	}
	
}
