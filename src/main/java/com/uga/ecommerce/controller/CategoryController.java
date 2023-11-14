package com.uga.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uga.ecommerce.config.AuthUtil;
import com.uga.ecommerce.entity.Category;
import com.uga.ecommerce.entity.Product;
import com.uga.ecommerce.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@GetMapping("/getCategories")
	public ResponseEntity<?> getAllCategories(){
		
		List<Category> categories = categoryService.getAllCategories();
		
	    return new ResponseEntity<Category>(HttpStatus.OK);
		
	}
	
	
	

}
