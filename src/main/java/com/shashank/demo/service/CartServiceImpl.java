package com.shashank.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shashank.demo.dao.CartDao;
import com.shashank.demo.entity.Cart;
import com.shashank.demo.entity.UserDetail;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDao cartDao;

	@Override
	public void saveCart(Cart cart) {
		// TODO Auto-generated method stub
		cartDao.save(cart);
	}

	@Override
	public List<Cart> getCartByUserDetail(UserDetail userDetail) {
		// TODO Auto-generated method stub
		
		return cartDao.findByUserDetail(userDetail);
	}

	@Override
	public Cart getCartByid(int id) {
		// TODO Auto-generated method stub
		return cartDao.findById(id).get();
	}

	@Override
	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub
		cartDao.saveAndFlush(cart);
		
	}

	@Override
	public void deleteCart(Cart cart) {
		// TODO Auto-generated method stub
		cartDao.delete(cart);
	}

}
