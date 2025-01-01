package com.shashank.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="user_detail")
public class UserDetail implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email",unique=true)
	private String email;
	
	@Column(name="phone_no",unique=true)
	private long phoneNo;
	
	@Column(name="date_of_birth")
	private LocalDate dob;
	
	@Column(name="address")
	private String address;
	
	@Column(name="username",unique=true)
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="enable")
	private String enable;
	
	@Transient
	private String authority;// database ma basdaina // do not persist this field in to database
	
	@OneToOne(mappedBy="userDetail", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private UserRole userRole;

	
	@OneToMany(mappedBy="userDetail", cascade=CascadeType.ALL)
	private List<Cart> cartList;
	
	@OneToMany(mappedBy="userDetail")
	private List<Comments> comment;
	
	public UserDetail() {
		super();
	}

	public UserDetail(int id, String firstName, String lastName, String email, long phoneNo, LocalDate dob,
			String address, String username, String password, String enable, String authority, UserRole userRole,List<Cart> cartList) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.dob = dob;
		this.address = address;
		this.username = username;
		this.password = password;
		this.enable = enable;
		this.authority = authority;
		this.userRole = userRole;
		this.cartList=cartList;
	}

	public List<Cart> getCartList() {
		return cartList;
	}

	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
}
