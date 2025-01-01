package com.shashank.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shashank.demo.dao.CommentsDao;
import com.shashank.demo.entity.Comments;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentsDao commentsDao;

	@Override
	public void saveComment(Comments comment) {
		commentsDao.save(comment);
		
	}

	@Override
	public List<Comments> getCommentByProduct(int product_id) {
		// TODO Auto-generated method stub
		return commentsDao.findByProduct_Id(product_id);
	}

	@Override
	public List<Comments> getAllComments() {
		// TODO Auto-generated method stub
		return commentsDao.findAll();
	}

	

}
