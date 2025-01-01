package com.shashank.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shashank.demo.entity.Category;
import com.shashank.demo.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {
	
	@Autowired 
	private CategoryService categoryService;
	@GetMapping
	public List<Category> getAllCategories(){
		return categoryService.getAllCategories();
	}
	
	@GetMapping("{id}")
	public Category getCategoryById(@PathVariable int id) {
		return categoryService.getCategoryById(id);
	}
	
	@PostMapping // save new category
	public Category saveCategory(@RequestBody Category category) {
		Category cat=categoryService.addCategory(category);
		return cat;
	}
	
	@PutMapping("/{id}") // update existing category
	public Category updateCategory(@RequestBody Category category, @PathVariable int id) {
		Category cat=categoryService.getCategoryById(id);
		if(cat!=null) {
			cat.setName(category.getName()); // copies values field-to-field
			cat.setDescription(category.getDescription());
			cat.setParentCat(category.getParentCat());
			cat.setProducts(category.getProducts());
			categoryService.updateCategory(cat);
			
		}
		return cat;
	}
	
	@DeleteMapping("/{id}")
	public Category deleteCategory(@PathVariable int id) {
		Category cat=categoryService.getCategoryById(id);
		if(cat!=null) {
			categoryService.deleteCategory(cat);
		}
		return cat;
	}
}
