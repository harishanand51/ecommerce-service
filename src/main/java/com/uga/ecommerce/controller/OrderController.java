package com.uga.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uga.ecommerce.entity.Customer;
import com.uga.ecommerce.entity.Order;
import com.uga.ecommerce.entity.Product;
import com.uga.ecommerce.service.OrderService;

//@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/addProductToCart/{productId}")
	public ResponseEntity<?> addItemsToOrder(@PathVariable Long productId, UsernamePasswordAuthenticationToken authObj) {
		
		//mind the quantity
		
		Customer customer= (Customer) authObj.getPrincipal();
		Long customerId = customer.getId();
		//order.setCustomer((Customer) authObj.getPrincipal());
		
		
		orderService.addProductToCart(productId, customerId);
		
		
		
		return new ResponseEntity<Product>(HttpStatus.OK);
		
	}

}
