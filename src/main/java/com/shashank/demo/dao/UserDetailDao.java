package com.shashank.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shashank.demo.entity.UserDetail;

@Repository
public interface UserDetailDao extends JpaRepository <UserDetail, Integer>{
	public UserDetail findByUsername(String username);
	
	public UserDetail findByEmail(String email);
}
