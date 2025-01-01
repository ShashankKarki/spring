package com.shashank.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shashank.demo.dao.OrderDao;
import com.shashank.demo.entity.OrderModel;
import com.shashank.demo.entity.UserDetail;

@Service
public class OrderModelServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;

	@Override
	public OrderModel saveOrder(OrderModel orderModel) {
		// TODO Auto-generated method stub
		OrderModel om= orderDao.save(orderModel);
		return om;
	}

	@Override
	public List<OrderModel> getAllOrders() {
		
		return orderDao.findAll();
	}

	@Override
	public OrderModel getOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> getOrderByUserDetail(UserDetail userDetail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrder(OrderModel orderModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrder(OrderModel orderModel) {
		// TODO Auto-generated method stub
		
	}

}
