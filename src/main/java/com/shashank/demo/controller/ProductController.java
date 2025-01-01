package com.shashank.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shashank.demo.entity.Product;
import com.shashank.demo.service.CategoryService;
import com.shashank.demo.service.ProductService;
import com.shashank.demo.service.UploadService;

@Controller
public class ProductController {
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UploadService uploadService;
	@Autowired
	private ProductService productService;
	
	@GetMapping("/admin/product/add")
	public String addProduct(Model model) {
		model.addAttribute("product_list", productService.getAllProducts());
		model.addAttribute("cat_list",categoryService.getAllCategories());
		return "product";
	}
	
	@PostMapping("/admin/product/add")
	public String saveProduct(@ModelAttribute Product product) {
		
		System.out.println(product); //display a toString version of product object
		
		if(uploadService.uploadProductImage(product.getImageFile())) {
			product.setImageName(product.getImageFile().getOriginalFilename());
			product.setAddedDate(LocalDate.now());
			productService.saveProduct(product);
			return "redirect:/admin/product/show";
		}
		
		return "redirect:/admin/product/add?upload_failed=ture";
	}
	
	@GetMapping("/admin/product/show")
	public String showProduct(Model model) {
		model.addAttribute("product_list", productService.getAllProducts());
		model.addAttribute("cat_list",categoryService.getAllCategories());
		return "product";
	}
	
	@GetMapping("admin/product/edit/{pid}")
	public String editProduct(@PathVariable("pid") int id, Model model) {
		model.addAttribute("product_list",productService.getAllProducts());
		model.addAttribute("edit_product",productService.findProductById(id));
		model.addAttribute("cat_list",categoryService.getAllCategories());
		model.addAttribute("edit",true);
		return "product";
	}
	
	@PostMapping("admin/product/edit")
	public String updateProduct(@ModelAttribute Product product, Model model) {
		Product oldProduct=productService.findProductById(product.getId());
		System.out.println("Showing product from edit:");
		System.out.println(product);
		if(product.getImageFile().isEmpty()==false) {
			System.out.println("update image so deleting old");
				if(uploadService.deleteProductImage(oldProduct.getImageName())) {
					if(uploadService.uploadProductImage(product.getImageFile())) {
						product.setImageName(product.getImageFile().getOriginalFilename());
						product.setAddedDate(LocalDate.now());
						productService.saveProduct(product);
						return "redirect:/admin/product/show?edit=sucess";
					}
					else {return "redirect:/admin/product/show?edit=failed";}
				}else {
					return "redirect:/admin/product/show?edit=failed";
				}
		}
		else {
			product.setImageName(oldProduct.getImageName());
			product.setAddedDate(LocalDate.now());
			productService.saveProduct(product);
			return "redirect:/admin/product/show?edit=sucess";
		}
					
		}
		
	
	@GetMapping("admin/product/delete/{pid}")
	public String deleteProduct(@PathVariable("pid")int id) {
		Product product=productService.findProductById(id);
		
		if(product!=null) {
			if(uploadService.deleteProductImage(product.getImageName())) {
			productService.deleteProduct(product);
			return "redirect:/admin/product/show?delete=sucess";
			}else {
				return "redirect:/admin/product/show?delete=failed";
			}
		}else {
		return "redirect:/admin/product/show?delete=failed";
	}
		
	}
	
	
}
