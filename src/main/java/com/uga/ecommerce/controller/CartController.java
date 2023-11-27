package com.uga.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uga.ecommerce.entity.ProductCart;
import com.uga.ecommerce.entity.Product;
import com.uga.ecommerce.response.CartResponse;
import com.uga.ecommerce.service.CartService;



@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	
	
	@GetMapping("/getProductsInCart/{cartId}")
	public ResponseEntity<?> getProductsInCart(@PathVariable Long cartId){
		
		List<CartResponse> cartResponses = cartService.getProductsInCart(cartId);
		//CartProductResponse cartProductRespone = new CartProductResponse(products, quantity);
		
		return new ResponseEntity<>(cartResponses, HttpStatus.OK);
		
	}
	
	@PostMapping("/addProductToCart")
	public ResponseEntity<?> addProductToCart(@RequestBody ProductCart productCart ){
		
//		Long cartId = productCart.getId().getCart().getId();
//        Long productId = productCart.getId().getProduct().getId();
//        Integer quantity = productCart.getQuantity();
		
		Long cartId = productCart.getCart().getId();
		Long productId = productCart.getProduct().getId();
		Integer quantity = productCart.getQuantity();
		
		String response = cartService.addProductToCart(cartId,productId,quantity);
		
		if(response.matches("Product added to the cart successfully")) {
			
			CartResponse cartResponse = new CartResponse(productCart.getProduct(), quantity);
			return new ResponseEntity<>(cartResponse, HttpStatus.OK);
		}
		
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/removeProductFromCart")
	public ResponseEntity<?> removeProductFromCart(@RequestBody ProductCart productCart){
		
//		Long cartId = productCart.getId().getCart().getId();
//        Long productId = productCart.getId().getProduct().getId();
		Long cartId = productCart.getCart().getId();
		Long productId = productCart.getProduct().getId();
		String response = cartService.removeProductFromCart(cartId, productId);
		
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	@GetMapping("/dummyapi")
	public ResponseEntity<?> dummyapi(){
		
		//Integer randomDouble = (int) Math.random();
		
		Integer min = 0;
        Integer max = 50;
        Integer randomCartId = (int) (Math.random() * (max - min) + min);
		
		return new ResponseEntity<>(randomCartId, HttpStatus.OK);
	}
	
	
	

}
