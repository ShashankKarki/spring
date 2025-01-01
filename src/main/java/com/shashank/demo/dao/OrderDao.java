package com.shashank.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shashank.demo.entity.OrderModel;
import com.shashank.demo.entity.UserDetail;

public interface OrderDao extends JpaRepository<OrderModel,Integer>{
	public List<OrderModel> findByUserDetail(UserDetail userDetail);
}
