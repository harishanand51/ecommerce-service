package com.uga.ecommerce.service;

//import java.util.List;

import com.uga.ecommerce.entity.Review;

public interface ReviewService {
	
	public Review getReviewById(Long id);

	public Review addReviews(Review review);
	
	public Review getReview(Long customerId, String comment);
	
	public Review updateReviews(Review review);
}
