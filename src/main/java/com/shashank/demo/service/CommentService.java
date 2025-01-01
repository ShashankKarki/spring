package com.shashank.demo.service;

import java.util.List;

import com.shashank.demo.entity.Comments;

public interface CommentService {
	
	public void saveComment(Comments comment);
	
	public List<Comments> getCommentByProduct(int product_id);
	
	public List<Comments> getAllComments();
}
