package com.uga.ecommerce.controller;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uga.ecommerce.entity.Customer;
import com.uga.ecommerce.entity.Order;
import com.uga.ecommerce.entity.Product;
import com.uga.ecommerce.entity.Cart;
import com.uga.ecommerce.entity.Review;
import com.uga.ecommerce.service.CartService;
import com.uga.ecommerce.service.OrderService;
import com.uga.ecommerce.repo.CartRepo;
import com.uga.ecommerce.repo.OrderRepo;


@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	CartRepo cartRepo;
	
	@Autowired
	OrderRepo orderRepo;
	
	@PostMapping("/addProductToCart/{productId}")
	public ResponseEntity<?> addItemsToOrder(@PathVariable Long productId, UsernamePasswordAuthenticationToken authObj) {
		
		//mind the quantity
		
		Customer customer= (Customer) authObj.getPrincipal();
		Long customerId = customer.getId();
		//order.setCustomer((Customer) authObj.getPrincipal());
		
		
		orderService.addProductToCart(productId, customerId);
		
		
		
		return new ResponseEntity<Product>(HttpStatus.OK);
		
	}
	
	@GetMapping("/getOrderDetails/{reqCartId}")
	public ResponseEntity<?> getCartDetailsByCartId(@PathVariable Long reqCartId , UsernamePasswordAuthenticationToken authObj) {
		//@RequestBody Map<String, Object> requestBody
		// Mind the quantity
		Customer customer = (Customer) authObj.getPrincipal();
		Long customerId = customer.getId();
		
        //Long cartId = ((Number) requestBody.get("id")).longValue();
		
		// Add product to cart
		
		
        Optional<Cart> cartOptional = cartRepo.findById(reqCartId);
        
        if (cartOptional.isEmpty()) {
            // Cart not found, return a response indicating no cart information
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No cart information found.");
        }
        
        Cart cart = cartOptional.get();
        
        float amount = cart.getCartTotal();
        
        Order order = new Order();
        
        order.setTotalAmount((float) (amount * 0.08));
        
        if(orderRepo.existsByCartId(reqCartId)) {
        	
        	return new ResponseEntity<>("Cart Id already got ordered", HttpStatus.ALREADY_REPORTED);
        }
        
        order.setCart(cart);
        //order.setCart_id(cartId);
        
        order.setCustomer(customer);
        
        LocalDateTime date = order.getOrderDate();
        
        order.setOrderDate(date);
        
        
        orderService.addOrder(order);
        
//        cartRepo.deleteCartById(reqCartId);
        
        cartRepo.deleteById(reqCartId);
//        
//        
//		// Assuming you have a method to get cart details from the cart table
//		CartDetails cartDetails = orderService.getCartDetails();
//		
//		// Assuming you have a method to convert cart details to an order
//		Order order = convertCartToOrder(cartDetails, customer);
//		
//		// Assuming you have a method to save the order to the order table
//		orderService.saveOrder(order);
//		

		
		return new ResponseEntity<>(order, HttpStatus.CREATED);
	}
	
	
	
	// cancel order

}
