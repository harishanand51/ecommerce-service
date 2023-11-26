package com.uga.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uga.ecommerce.entity.ProductCart;
import com.uga.ecommerce.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PostMapping("/addProductToCart")
	public ResponseEntity<?> addProductToCart(@RequestBody ProductCart productCart ){
		
		Long cartId = productCart.getCart().getId();
		Long productId = productCart.getProduct().getId();
		Integer quantity = productCart.getQuantity();
		
		String response = cartService.addProductToCart(cartId,productId,quantity);
		
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/removeProductFromCart")
	public ResponseEntity<?> removeProductFromCart(@RequestBody ProductCart productCart){
		
		Long cartId = productCart.getCart().getId();
		Long productId = productCart.getProduct().getId();
		String response = cartService.removeProductFromCart(cartId, productId);
		
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

}
