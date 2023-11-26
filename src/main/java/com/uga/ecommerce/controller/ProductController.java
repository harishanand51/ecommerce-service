package com.uga.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uga.ecommerce.config.AuthUtil;
import com.uga.ecommerce.entity.Product;
import com.uga.ecommerce.response.LoginResponse;
import com.uga.ecommerce.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@GetMapping("/product/{name}")
	public ResponseEntity<?> getProduct(@PathVariable String name){
		
		logger.info("Inside get product"+name);
			
		List<Product> products = productService.getProductByName(name);
		
		logger.info("All prdoucts: "+products);
		
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	
	@GetMapping("/Allproducts")
	public ResponseEntity<?> getAllProducts(){
		
		logger.info("Inside getAll products");
			
		List<Product> products = productService.getAllProducts();
		
		logger.info("All prdoucts: "+products);
		
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	
	
	
	@PostMapping("/addProduct")
	public ResponseEntity<?> addproduct(@RequestBody Product product, UsernamePasswordAuthenticationToken authObj){
		
		logger.info("Inside add product"+product);
		
		if (!AuthUtil.authorizeAdminReuest(authObj)) {
			logger.info("User: {} is not an Admin", authObj.getName());
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
		if(!productService.getProductByName(product.getProductName()).isEmpty()){
			
			 return new ResponseEntity<>("Product is already present", HttpStatus.ALREADY_REPORTED);
		}
		
		
		productService.addProduct(product);
		
		return new ResponseEntity<>(product, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/deleteProduct/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long productId, UsernamePasswordAuthenticationToken authObj){
		
		logger.info("Inside delete product"+productId);
		
		if (!AuthUtil.authorizeAdminReuest(authObj)) {
			logger.info("User: {} is not an Admin", authObj.getName());
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
		productService.deleteProduct(productId);
		
		return new ResponseEntity<>(
				new LoginResponse.LoginResponseBuilder().setErrMsg("Product Successfuly Deleted").build(), HttpStatus.OK);
		
	}
	
	@PostMapping("/editProduct")
	public ResponseEntity<?> editProduct(@RequestBody Product product, UsernamePasswordAuthenticationToken authObj){
		
		logger.info("Inside edit product"+product);
		
		if (!AuthUtil.authorizeAdminReuest(authObj)) {
			logger.info("User: {} is not an Admin", authObj.getName());
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
		product = productService.editProduct(product);
		
		return new ResponseEntity<>(product, HttpStatus.OK);
		
	}

}
