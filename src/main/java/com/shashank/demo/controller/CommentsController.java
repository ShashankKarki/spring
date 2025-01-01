package com.shashank.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shashank.demo.entity.Comments;
import com.shashank.demo.service.CommentService;
import com.shashank.demo.service.ProductService;
import com.shashank.demo.service.UserDetailService;

@Controller
public class CommentsController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired 
	private CommentService commentService;
	
	@PostMapping("user/comments/add")
	public String addComment(@RequestParam("comment") String user_comment , @RequestParam("product_id") int product_id,Principal p) {
		if (p == null) {
		    // Handle the case where the user is not authenticated (e.g., redirect to login page)
		    return "redirect:/login";
		}
		else {
			Comments comment=new Comments();
			comment.setComment(user_comment);
			System.out.println(user_comment);
			comment.setProduct(productService.findProductById(product_id));
			comment.setUserDetail(userDetailService.getUserDetailByUsername(p.getName()));
			commentService.saveComment(comment);
			return "redirect:/products";
		}
				
	}
}
