package com.shashank.demo.service;

import java.util.List;

import com.shashank.demo.entity.UserDetail;

public interface UserDetailService {
	public void saveUserDetail(UserDetail userDetail);
	
	public List<UserDetail> getAlluserDetails();
	
	public UserDetail getUserDetailById(int id);
	
	public UserDetail getUserDetailByUsername(String username);
	
	public void updateUserDetail(UserDetail userDetail);
	
	public void deleteUserDetail(UserDetail userDetail);
}
