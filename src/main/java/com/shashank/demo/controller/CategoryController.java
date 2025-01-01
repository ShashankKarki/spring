package com.shashank.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shashank.demo.entity.Category;
import com.shashank.demo.service.CategoryService;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping("/add") // '/admin/category/add'
	public String addCategory(Principal p,Model model) {
		String username=p.getName(); 
		//Principal object is used to retrieve user who belongs to current session
		model.addAttribute("user", username);
		//Model object is used to send data to view (jsp page)
		
		model.addAttribute("cat_list",categoryService.getAllCategories());
		return "category";
	}
	
	@PostMapping("/add")
	public String saveCategory(@RequestParam("cat_name") String name,@RequestParam("cat_description") String description,
								@RequestParam("cat_parent") int parentCategory) {
		Category category= new Category();
		category.setName(name);
		category.setDescription(description);
		category.setParentCat(parentCategory);
		
		//save category detail via categoryService to categoryDao
		categoryService.addCategory(category);
		
		//redirect to a fresh url using response as send redirect method
		//sidai return "cateogry" garya vaye reload garda feri submit hunxa 
		return "redirect:/admin/category/add";
	}
	
	@GetMapping("/edit/{cid}")
	public String editCategory(@PathVariable("cid") int id, Model model) {
	model.addAttribute("edit",true);
	model.addAttribute("cat_list",categoryService.getAllCategories());
	model.addAttribute("edit_cat",categoryService.getCategoryById(id));
	return "category";
	}
	
	@PostMapping("edit")
	public String updateCategory(@ModelAttribute("cateogry") Category category) {
		categoryService.updateCategory(category);
		return "redirect:/admin/category/show#category_data";
	}
	
	@GetMapping("/show")
	public String showCategory(Model model) {
		model.addAttribute("cat_list",categoryService.getAllCategories());
		return "category";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCategory(@PathVariable int id) {
		Category cat= categoryService.getCategoryById(id); //delete presistence object
		//Category cat= new Category();//deleting transient object
		if(cat!=null) {
			categoryService.deleteCategory(cat);
			return "redirect:/admin/category/show#category_data?delete=sucess";
		}
		else {
			return "redirect:/admin/category/show#category_data?delete=failed";
		}
	}
}
