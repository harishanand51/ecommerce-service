package com.uga.ecommerce.controller;



import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.uga.ecommerce.config.AuthUtil;
import com.uga.ecommerce.entity.Customer;
import com.uga.ecommerce.entity.Product;
import com.uga.ecommerce.entity.Review;
import com.uga.ecommerce.service.CustomerService;
import com.uga.ecommerce.service.ProductService;
import com.uga.ecommerce.service.ReviewService;

@RestController
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CustomerService customerService;
	
	Logger logger  = LoggerFactory.getLogger(ReviewController.class);
	
	// , UsernamePasswordAuthenticationToken authObj
	
	@PostMapping("/addReview")
	public ResponseEntity<?> addreview(@RequestBody Review review){
		
		logger.info("Inside add review"+review);
		
		
		
//		if (!AuthUtil.authorizeAdminReuest(authObj)) {
//			logger.info("User: {} is not an Admin", authObj.getName());
//			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//		}
		
		// if(!reviewService.getProductByName(reviewService.getProductName()).isEmpty()){
			
		// 	 return new ResponseEntity<>("Product is already present", HttpStatus.ALREADY_REPORTED);
		// }
		
		Product product = productService.getProductById(review.getProduct().getId());
		Long productId = product.getId();
		
		//Optional<Customer> customerData = customerService.getCustomerByEmail(review.getCustomer().getEmail());
		//Customer customer = customerData.get();
		//Long customerId = customer.getId();
		
		//logger.info("commment"+customerId);
		
//		review.setProductId(productId);
//		review.setCustomerId(customerId);
//		if(!reviewService.getReview(customerId, review.getComment()).isEmpty())
		Review existingReview = reviewService.getReview(review.getComment());
		
		logger.info("is there or not "+ existingReview);
		
		if(existingReview != null){
//				(product.getProductName()).isEmpty()){
			
			 return new ResponseEntity<>("Product is already present", HttpStatus.ALREADY_REPORTED);
		}
		
		reviewService.addReviews(review);
		
		return new ResponseEntity<>(review, HttpStatus.CREATED);
		
	}
	
	
	
	@PostMapping("/updateReview")
	public ResponseEntity<?> updateReview(@RequestBody Review review){
		
		logger.info("Inside update review"+ review);
		
		
		Review existingReview = reviewService.getReviewById(review.getId());
		
		logger.info("is there or not "+ existingReview);
		
		if (existingReview != null) {
	        // Update the comment information
	        existingReview.setComment(review.getComment());
	        
	        // Call the updateReviews method (assuming this method updates the review in the database)
	        reviewService.updateReviews(existingReview);


	        return new ResponseEntity<>(existingReview, HttpStatus.OK);
	    }
		
		
		return new ResponseEntity<>(review, HttpStatus.NOT_MODIFIED);
		
	}
	
}