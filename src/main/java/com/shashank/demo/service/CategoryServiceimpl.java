package com.shashank.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shashank.demo.dao.CategoryDao;
import com.shashank.demo.entity.Category;

@Service
@Transactional
public class CategoryServiceimpl implements CategoryService{
	
	private CategoryDao categoryDao;
	@Autowired
	public CategoryServiceimpl(CategoryDao categoryDao) {
		this.categoryDao=categoryDao;
	}

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		// categoryDao.save(category);
		Category cat= categoryDao.save(category);
		System.out.println("Primary key generated: "+cat.getId());
		return cat;
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return categoryDao.findById(id).orElse(new Category());
	}

	@Override
	public Category getCategoryByName(String name) {
		// TODO Auto-generated method stub
		return categoryDao.findByName(name);
	}

	@Override
	public List<Category> getCategoryByParent(int parentId) {
		// TODO Auto-generated method stub
		return categoryDao.findByParentCat(parentId);
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		categoryDao.save(category);// for update operation the category object must have id fieldset to value other than 0
		//or else a new category will be inserted 
		
	}

	@Override
	public void deleteCategory(Category category) {
		// TODO Auto-generated method stub
		categoryDao.delete(category);
		
	}

}
