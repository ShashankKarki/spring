package com.shashank.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shashank.demo.service.CommentService;
import com.shashank.demo.service.ProductService;
/**
 * Controllers are servlet in java web and enterprise applications 
 * IN spring we have a builtin controller or FrameworkServlet called DispatcherServlet
 * every request is confiqured to come through dispatcher servlet and it will tell how to 
 * process this request by calling secondary controllers like HomeController
 */
@Controller
public class HomeController {
	//request handler methods
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CommentService commentService;
	
	
	@RequestMapping(value={"/","/index","/home"},method=RequestMethod.GET)
	public String openHome() {
		//request handler method is bind with a url pattern which dispatcher servlet lists down
		//at the beginign of a app,and when a request comes for that url this method is invoked by
		//dispatcher servlet , and provides a required service for that requset
		
		//return statement returns a view-name which is resolved into actual page acording to 
		//veiwresolver bean configuration provided in  application context file 
		return "index";
	}
	@RequestMapping(value="/about",method=RequestMethod.GET)
	public String openAbout() {
		return "about";
	}
	
	@RequestMapping(value="/contact",method=RequestMethod.GET)
	public String openContact() {
		return "contact";
	}
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public String openProducts(Model model) {
		//model.addAttribute("popular_products",productService.getAllProducts());
		//model.addAttribute("featured_products",productService.getAllProducts());
		model.addAttribute("all_products",productService.getAllProducts());
		model.addAttribute("all_comments",commentService.getAllComments());
		return "products";
	}
}
