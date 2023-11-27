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
import com.uga.ecommerce.entity.PaymentTransaction;
import com.uga.ecommerce.entity.Product;
import com.uga.ecommerce.entity.Order;
import com.uga.ecommerce.entity.Review;
import com.uga.ecommerce.repo.OrderRepo;
import com.uga.ecommerce.response.LoginResponse;
import com.uga.ecommerce.service.CustomerService;
import com.uga.ecommerce.service.OrderService;
import com.uga.ecommerce.service.PaymentTransactionService;
import com.uga.ecommerce.service.ProductService;
import com.uga.ecommerce.service.ReviewService;

@RestController
public class PaymentTransactionController {
	
	@Autowired
	PaymentTransactionService paymentTransactionService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CustomerService customerService;
	
	Logger logger  = LoggerFactory.getLogger(ReviewController.class);
	
	
	@PostMapping("/makeTransaction")
	public ResponseEntity<?> makePaymentTransaction(@RequestBody PaymentTransaction paymentTransaction){
		
		logger.info("Inside add review"+paymentTransaction);
		
		
		
		Long orderId = paymentTransaction.getOrder().getId();
		
		
		Order orderDetails = orderRepo.getById(orderId);
		
		paymentTransaction.setOrder(orderDetails);
		
		paymentTransaction.setPaymentAmount(orderDetails.getTotalAmount());
		
		
		paymentTransactionService.addPaymentTransaction(paymentTransaction);
		
		return new ResponseEntity<>(paymentTransaction, HttpStatus.CREATED);
		
	}

}
	