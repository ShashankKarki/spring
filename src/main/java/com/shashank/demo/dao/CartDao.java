package com.shashank.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.shashank.demo.entity.Cart;
import com.shashank.demo.entity.UserDetail;

public interface CartDao extends JpaRepository<Cart,Integer>{
	
	public List<Cart> findByUserDetail(UserDetail userDetail);
	
	@Modifying
	@Query("delete from Cart c where c.userDetail=:userDetail")
	public void deleteByUserDetail(UserDetail userDetail);
}
