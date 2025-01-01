package com.shashank.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user_role")

public class UserRole implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private int id;
	
	@Column(name="role_role")
	private String role; // ROLE_ADMIN, ROLE_USER
	
	@OneToOne
	@JoinColumn(name="user_id")
	private UserDetail userDetail;// creates a relation between two relations: user_detail and User_role 
	//with foreign key stored in users_role table as user_id

	public UserRole() {
		super();
	}

	public UserRole(int id, String role, UserDetail userDetail) {
		super();
		this.id = id;
		this.role = role;
		this.userDetail = userDetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	
	
}
