package com.shashank.demo.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.shashank.demo.entity.Cart;
import com.shashank.demo.entity.OrderModel;
import com.shashank.demo.entity.OrderedProduct;
import com.shashank.demo.entity.UserDetail;
import com.shashank.demo.service.CartService;
import com.shashank.demo.service.OrderService;
import com.shashank.demo.service.UserDetailService;

@Controller
public class OrderController {
	@Autowired
	private UserDetailService userDetailService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;
	
	@GetMapping("/user/payment/sucess/{agent}")
	
	
	public String makeOrder(@PathVariable String agent, Principal p,Model model) {
		System.out.println("Agent: "+agent);
		OrderModel order= new OrderModel();
		UserDetail userDetail=userDetailService.getUserDetailByUsername(p.getName());
		order.setUserDetail(userDetail);//owner of order set
		List<Cart> carts=userDetail.getCartList();
		List<OrderedProduct> orderList=new ArrayList<>();
		double total_amount=0;
		for(Cart cart: carts) {
			System.out.println("displaying cart");
			OrderedProduct op=new OrderedProduct();
			op.setProduct(cart.getProduct());
			op.setQuantity(cart.getQuantity());
			op.setOrderModel(order);
			orderList.add(op);
			total_amount+=cart.getProduct().getPrice()*cart.getQuantity();
			
		}
		order.setOrderedProducts(orderList);
		
		order.setTotal_amount(total_amount);
		order.setOrderDate(LocalDate.now());
		order.setDelivery_date(LocalDate.now().plusDays(5));
		order.setPayment_method(agent);
		order.setStatus("PENDING");
		
		OrderModel om=orderService.saveOrder(order);
		if (om!=null) {
			//delete user cart..
			for(Cart cart:carts) {
				System.out.println("deleteing cart");
				cartService.deleteCart(cart);
			}
		}
		model.addAttribute("order_detail",om);
		return "order_details";
	}
	
}
