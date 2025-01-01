package com.shashank.demo.service;

import java.util.List;


import com.shashank.demo.entity.Product;


public interface ProductService {
	public void saveProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public Product findProductById(int id);
	
	public void deleteProduct(Product product);
}
