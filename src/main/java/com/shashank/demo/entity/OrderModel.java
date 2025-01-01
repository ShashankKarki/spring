package com.shashank.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="order_table")
public class OrderModel implements Serializable{
	private static final long serialVersionUID = 23472374L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id")
	private int id;
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserDetail userDetail;
	
	@OneToMany(mappedBy="orderModel",cascade=CascadeType.ALL)
	private List<OrderedProduct> orderedProducts;
	
	private double total_amount;
	private double discount;
	@Column(name="order_date")
	private LocalDate orderDate;
	private LocalDate delivery_date;
	private String payment_method;
	private String status;
	// billing address..
	
	public OrderModel() {
		super();
	}
	
	
	public OrderModel(int id, UserDetail userDetail, List<OrderedProduct> orderedProducts, double total_amount,
			double discount, LocalDate orderDate, LocalDate delivery_date, String payment_method, String status) {
		super();
		this.id = id;
		this.userDetail = userDetail;
		this.orderedProducts = orderedProducts;
		this.total_amount = total_amount;
		this.discount = discount;
		this.orderDate = orderDate;
		this.delivery_date = delivery_date;
		this.payment_method = payment_method;
		this.status = status;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserDetail getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public LocalDate getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(LocalDate delivery_date) {
		this.delivery_date = delivery_date;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	public List<OrderedProduct> getOrderedProducts() {
		return orderedProducts;
	}


	public void setOrderedProducts(List<OrderedProduct> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}
	

}
