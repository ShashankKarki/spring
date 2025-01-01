package com.shashank.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shashank.demo.dao.ProductDao;
import com.shashank.demo.entity.Category;
import com.shashank.demo.entity.Product;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao productDao;
	
	@Override
	public void saveProduct(Product product) {
		productDao.save(product);
	}
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		return productDao.findById(id).get();
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.delete(product);
	}

	
}
