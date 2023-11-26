package com.uga.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uga.ecommerce.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PostMapping("/{cartId}/addProductToCart/{productId}/{quantity}")
	public ResponseEntity<?> addProductToCart(@PathVariable Long cartId, @PathVariable Long productId, @PathVariable Integer quantity){
		
		String response = cartService.addProductToCart(cartId,productId,quantity);
		
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/{cartId}/removeProductFromCart/{productId}")
	public ResponseEntity<?> removeProductFromCart(@PathVariable Long cartId, @PathVariable Long productId){
		
		
		String response = cartService.removeProductFromCart(cartId, productId);
		
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

}
