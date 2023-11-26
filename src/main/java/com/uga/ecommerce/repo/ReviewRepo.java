package com.uga.ecommerce.repo;


import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uga.ecommerce.entity.Review;

public interface ReviewRepo extends JpaRepository<Review, Long> 
{
  Review findByCustomerIdAndComment(Long customerId, String comment);
  
//  Optional<Review> findByReviewId(Long id);
}
