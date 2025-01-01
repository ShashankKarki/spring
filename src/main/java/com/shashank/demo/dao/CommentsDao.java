package com.shashank.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shashank.demo.entity.Comments;

@Repository
public interface CommentsDao extends JpaRepository<Comments,Integer>{
	public List<Comments> findByProduct_Id(int id);
}
