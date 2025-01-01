package com.shashank.demo.service;

import java.util.List;

import com.shashank.demo.entity.OrderModel;
import com.shashank.demo.entity.UserDetail;

public interface OrderService {
	public OrderModel saveOrder(OrderModel orderModel);
	
	public List<OrderModel> getAllOrders();
	
	public OrderModel getOrderById(int id);
	
	public List<OrderModel> getOrderByUserDetail(UserDetail userDetail);
	
	public void updateOrder(OrderModel orderModel);
	
	public void deleteOrder(OrderModel orderModel);
	
}
