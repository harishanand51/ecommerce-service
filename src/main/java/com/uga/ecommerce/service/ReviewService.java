package com.uga.ecommerce.service;

import java.util.*;

import com.uga.ecommerce.entity.Review;


public interface ReviewService {
	
	public Review getReviewById(Long id);

	public Review addReviews(Review review);
	
	public Review getReview(String comment);
	
	public Review updateReviews(Review review);

	public List<Review> getReviewByProductId(Long productId);
}
