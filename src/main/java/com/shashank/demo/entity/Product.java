package com.shashank.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="product_table")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int id;
	
	@Column(name="product_name", unique=true)
	private String name;
	
	private String description;
	
	private String tags;
	
	@Transient
	private MultipartFile imageFile;
	
	private String imageName;
	
	private String quantity;
	
	private double price;
	
	private LocalDate addedDate;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	
	@OneToMany(mappedBy="product")
	private List<Cart> cartList;
	
	@OneToMany(mappedBy="product")
	private List<OrderedProduct> orderedProduct;
	
	@OneToMany(mappedBy="product")
	private List<Comments> comment; 

	public Product() {
		super();
	}
	

	public Product(int id, String name, String description, String tags, MultipartFile imageFile, String imageName,
			String quantity, double price, LocalDate addedDate, Category category, List<Cart> cartList,
			List<OrderedProduct> orderedProduct, List<Comments> comment) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.tags = tags;
		this.imageFile = imageFile;
		this.imageName = imageName;
		this.quantity = quantity;
		this.price = price;
		this.addedDate = addedDate;
		this.category = category;
		this.cartList = cartList;
		this.orderedProduct = orderedProduct;
		this.comment = comment;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDate addedDate) {
		this.addedDate = addedDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	public MultipartFile getImageFile() {
		return imageFile;
	}


	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	public List<OrderedProduct> getOrderedProduct() {
		return orderedProduct;
	}


	public void setOrderedProduct(List<OrderedProduct> orderedProduct) {
		this.orderedProduct = orderedProduct;
	}
	
	

	public List<Comments> getComment() {
		return comment;
	}


	public void setComment(List<Comments> comment) {
		this.comment = comment;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", tags=" + tags
				+ ", imageFile=" + imageFile + ", imageName=" + imageName + ", quantity=" + quantity + ", price="
				+ price + ", addedDate=" + addedDate + ", category=" + category + "]";
	}
	
	

}
