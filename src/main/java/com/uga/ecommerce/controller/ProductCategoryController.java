package com.uga.ecommerce.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uga.ecommerce.config.AuthUtil;
import com.uga.ecommerce.entity.Category;
import com.uga.ecommerce.entity.Product;
import com.uga.ecommerce.entity.ProductCategory;
import com.uga.ecommerce.service.CategoryService;
import com.uga.ecommerce.service.ProductCategoryService;
import com.uga.ecommerce.service.ProductService;

@RestController
public class ProductCategoryController {
	
	@Autowired
	ProductCategoryService productCategoryService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@GetMapping("/getAllProductsinCategory/{category}")
	public ResponseEntity<?> getAllProductsinCategory(@PathVariable Category category, UsernamePasswordAuthenticationToken authObj){
		
		if (!AuthUtil.authorizeAdminReuest(authObj)) {
			logger.info("User: {} is not an Admin", authObj.getName());
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
		List<Product> products = productCategoryService.getAllProductsinCategory(category);
		
		if(products == null) {
			return new ResponseEntity<>("No Products in the Category", HttpStatus.OK);
		}
		
		return new ResponseEntity<>(products, HttpStatus.OK);
		
		
	}
	
	@PostMapping("/addProductToCategories")
	public ResponseEntity<?> addProductToCategories(@RequestBody ProductCategory reqProductCategory, UsernamePasswordAuthenticationToken authObj){
		
		if (!AuthUtil.authorizeAdminReuest(authObj)) {
			logger.info("User: {} is not an Admin", authObj.getName());
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
		//Product product = reqProductCategory.getProduct();
		//Category category = reqProductCategory.getCategory();
		
		Product product = productService.getProductById(reqProductCategory.getProduct().getId());
		Category category = categoryService.getcategoryById(reqProductCategory.getCategory().getId());
		
		if(productCategoryService.isProductMappedToCategory(product, category)) {
			return new ResponseEntity<>("Product is already mapped to Category", HttpStatus.ALREADY_REPORTED);
		}
		
		
		ProductCategory productCategory = productCategoryService.addProductToCategory(reqProductCategory);
		
		
	    return new ResponseEntity<>(productCategory, HttpStatus.OK);
		
	}
	
	@GetMapping("/removeProductFromCategory/{productId}/{categoryId}")
    public ResponseEntity<?> removeProductfromCategory(@PathVariable Long productId, @PathVariable Long categoryId, UsernamePasswordAuthenticationToken authObj){
		
		if (!AuthUtil.authorizeAdminReuest(authObj)) {
			logger.info("User: {} is not an Admin", authObj.getName());
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
		Product product = productService.getProductById(productId);
		Category category = categoryService.getcategoryById(categoryId);
		
		 
		
		if(product==null || category == null || !productCategoryService.isProductMappedToCategory(product, category)) {
			return new ResponseEntity<>("Invalid Product or Category", HttpStatus.NOT_FOUND);
		}
		
		productCategoryService.removeProductfromCategory(product,category);
    	
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	

}
