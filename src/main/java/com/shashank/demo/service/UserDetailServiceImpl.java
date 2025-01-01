package com.shashank.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shashank.demo.dao.UserDetailDao;
import com.shashank.demo.entity.UserDetail;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailService {
	@Autowired
	private UserDetailDao userDetailDao;

	@Override
	public void saveUserDetail(UserDetail userDetail) {
		// TODO Auto-generated method stub
		userDetailDao.save(userDetail);
	}

	@Override
	public List<UserDetail> getAlluserDetails() {
		// TODO Auto-generated method stub
		
		return userDetailDao.findAll();
	}

	@Override
	public UserDetail getUserDetailById(int id) {
		// TODO Auto-generated method stub
		
		return userDetailDao.findById(id).get();
	}

	@Override
	public UserDetail getUserDetailByUsername(String username) {
		// TODO Auto-generated method stub
		
		return userDetailDao.findByUsername(username);
	}

	@Override
	public void updateUserDetail(UserDetail userDetail) {
		// TODO Auto-generated method stub
		userDetailDao.save(userDetail);
		
	}

	@Override
	public void deleteUserDetail(UserDetail userDetail) {
		// TODO Auto-generated method stub
		userDetailDao.delete(userDetail);
	}

}
