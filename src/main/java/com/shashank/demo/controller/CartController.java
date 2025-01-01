package com.shashank.demo.controller;

import java.security.Principal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shashank.demo.entity.Cart;
import com.shashank.demo.entity.UserDetail;
import com.shashank.demo.service.CartService;
import com.shashank.demo.service.ProductService;
import com.shashank.demo.service.UserDetailService;

import jakarta.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("/user/cart")
public class CartController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/add/{pid}")
	public String addCart(@PathVariable int pid, Principal p, HttpServletRequest request) {
		Cart cart=new Cart();
		cart.setProduct(productService.findProductById(pid));
		cart.setQuantity(1);
		cart.setAddedDate(LocalDate.now());
		cart.setUserDetail(userDetailService.getUserDetailByUsername(p.getName()));
		
		cartService.saveCart(cart);
		String referer= request.getHeader("Referer");
		
		return "redirect:"+referer;
	}
	
	@GetMapping("/show")
	public String showCart(Model model,Principal p) {
		UserDetail userDetail=userDetailService.getUserDetailByUsername(p.getName());
		model.addAttribute("user_cart",cartService.getCartByUserDetail(userDetail));
		return "cart";
	}
	
	@GetMapping("/delete/{cart_id}")
	public String deleteCart(@PathVariable("cart_id") int id) {
		Cart cart=cartService.getCartByid(id);
		if(cart!=null) {
			cartService.deleteCart(cart);
			return "redirect:/user/cart/show?delete_cart=sucess";
		}
		else {
			return "redirect:/user/cart/show?delete_cart=failed";
		}
	}
	
}
