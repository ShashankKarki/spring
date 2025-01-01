package com.shashank.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order_product")
public class OrderedProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_product_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private OrderModel orderModel;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	private int quantity;

	public OrderedProduct() {
		super();
	}

	public OrderedProduct(int id, OrderModel orderModel, Product product, int quantity) {
		super();
		this.id = id;
		this.orderModel = orderModel;
		this.product = product;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrderModel getOrderModel() {
		return orderModel;
	}

	public void setOrderModel(OrderModel orderModel) {
		this.orderModel = orderModel;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}