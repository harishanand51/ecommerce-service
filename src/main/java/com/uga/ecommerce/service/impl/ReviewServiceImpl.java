package com.uga.ecommerce.service.impl;



import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;

import com.uga.ecommerce.entity.Product;
import com.uga.ecommerce.entity.Review;
import com.uga.ecommerce.repo.CustomerRepo;
import com.uga.ecommerce.repo.ProductRepo;
import com.uga.ecommerce.repo.ReviewRepo;

import com.uga.ecommerce.service.ReviewService;


@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewRepo reviewRepo;
	
	@Autowired
    ProductRepo productRepo;

    @Autowired
    CustomerRepo customerRepo;
    
    @PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public Review addReviews(Review review){
		
//		Product product = productRepo.findByProductName(productName);
//        Customer customer = customerRepo.findByEmail(customerEmail);
//        
//        if (product != null && customer != null) {
//            Review review = new Review();
//            review.setProduct(product);
//            review.setCustomer(customer);
//            review.setRating(rating);
//            review.setComment(comment);
//
//            return reviewRepo.save(review);
//        }

		Review rw = reviewRepo.save(review);
		
		return rw;
	}

	@Override
    public Review getReview(Long customerId, String comment) {
        return reviewRepo.findByCustomerIdAndComment(customerId, comment);
    }
	
	public Review updateReviews(Review review){
			
	//		Product product = productRepo.findByProductName(productName);
	//        Customer customer = customerRepo.findByEmail(customerEmail);
	//        
	//        if (product != null && customer != null) {
	//            Review review = new Review();
	//            review.setProduct(product);
	//            review.setCustomer(customer);
	//            review.setRating(rating);
	//            review.setComment(comment);
	//
	//            return reviewRepo.save(review);
	//        }
	
			Review rw = reviewRepo.save(review);
			
			return rw;
		}

	@Override
    public Review getReviewById(Long id) {
		Optional<Review> review = reviewRepo.findById(id);

        // You can handle the case where the review is not found, e.g., throw an exception or return null
        return review.orElse(null);
    }
	
	
	private Review detachReview(Review review) {
        entityManager.detach(review);
        return review;
    }

	 
	// @Autowired
	// ProductRepo productRepo;

	// @Override
	// public List<Product> getProductByName(String name) {
		
	// 	return productRepo.findByProductName(name);
	// }
	
	// @Override
	// public Product getProductById(Long id) {
		
	// 	Optional<Product> product = productRepo.findById(id);
		
	// 	return product.get();
	// }

	// @Override
	// @Transactional
	// public Product addProduct(Product product) {
		
	// 	product = productRepo.save(product);
		
	// 	return product;
	// }

	// @Override
	// public void deleteProduct(Long productId) {
		
	// 	productRepo.deleteById(productId);
		
	// }


	// @Override
	// @Transactional
	// public Product editProduct(Product product) {
		
	// 	Product existingProduct = getProductById(product.getId());
		
	// 	if(product.getProductName() != null)
	// 		existingProduct.setProductName(product.getProductName());
		
	// 	if(product.getDescription() != null)
	// 		existingProduct.setDescription(product.getDescription());
		
	// 	if(product.getPrice() != null)
	// 		existingProduct.setPrice(product.getPrice());
		
	// 	if(product.getStockQuantity() != null)
	// 		existingProduct.setStockQuantity(product.getStockQuantity());
		
	// 	existingProduct = productRepo.save(existingProduct);
		
	// 	return product;
	// }

	
	
	
}
