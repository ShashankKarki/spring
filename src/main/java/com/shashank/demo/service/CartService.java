package com.shashank.demo.service;

import java.util.List;

import com.shashank.demo.entity.Cart;
import com.shashank.demo.entity.UserDetail;

public interface CartService {
	public void saveCart(Cart cart);
	
	public List<Cart> getCartByUserDetail(UserDetail userDetail);
	
	public Cart getCartByid(int id);
	
	public void updateCart(Cart cart);
	
	public void deleteCart(Cart cart);
	
}
