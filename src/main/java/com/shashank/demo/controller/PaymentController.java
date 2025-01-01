package com.shashank.demo.controller;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shashank.demo.dto.PaymentDto;
import com.shashank.demo.entity.Cart;
import com.shashank.demo.entity.UserDetail;
import com.shashank.demo.service.PaymentService;
import com.shashank.demo.service.UserDetailService;

@Controller
public class PaymentController {
	@Autowired 
	UserDetailService userDetailService;
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/user/payment/esewa")
	public String payViaEsewa(Principal p, Model model) {
		UserDetail userDetail= userDetailService.getUserDetailByUsername(p.getName());
		PaymentDto payment=new PaymentDto();
		List<Cart> cartList= userDetail.getCartList();
		double amount=0;
		for(Cart cart: cartList) {
			amount += (cart.getProduct().getPrice()*cart.getQuantity());
		}
		payment.setAmount(amount);
		payment.setPsc(100);
		payment.setPdc(100);
		payment.setTaxAmount(amount*0.13);
		payment.setTotalAmount(Math.ceil(amount*1.13 + 100 + 100));
		payment.setProductCode("EPAYTEST");
		payment.setTransactionUID(UUID.randomUUID()+"-OC81");
		payment.setSignedFields("total_amount,transaction_uuid,product_code");
		String message="total_amount="+payment.getTotalAmount()+",transaction_uuid="+payment.getTransactionUID()+",product_code="+payment.getProductCode();
		payment.setSignature(paymentService.generateEsewaSignature("8gBm/:&EnhH.1/q", message));
		payment.setSucessUrl("http://localhost:9090/user/payment/sucess/esewa");
		payment.setFaliureUrl("http://localhost:9090/user/payment/faliure/esewa");
		model.addAttribute("user_detail",userDetail);
		model.addAttribute("payment",payment);
		
		return "esewa_payment";
	}
}
