package com.uga.ecommerce.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="review")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="review_id")
	private Long Id;
	
//	@ManyToOne
    

//    @ManyToOne
    
	
////	@Id
////	@GeneratedValue(strategy = GenerationType.IDENTITY)
////	//@Column(name="review_id")
////	private Long Id;
//	
	//@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@ManyToOne
	@JoinColumn(name="product_id", nullable = false)
	//@JsonIgnore
	private Product product;
	
//	private Long productId;
	
	//@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@ManyToOne
	@JoinColumn(name="customer_id",  nullable=false)
	//@JsonIgnore
	private Customer customer;
	
//	private Long customerId;
	
    
    
	@Column(name="rating")
	private Integer rating;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="review_date")
	private LocalDateTime reviewDate;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

//	public Long getProductId() {
//		return productId;
//	}
	
	public Product getProduct() {
		return product;
	}

//	public void setProductId(Long productId) {
//		this.productId = productId;
//	}
	
	public void setProduct(Product product) {
		this.product = product;
	}

//	public Long getCustomerId() {
//		return customerId;
//	}
//	
	public Customer getCustomer() {
		return customer;
	}

//	public void setCustomer(Long customerId) {
//		this.customerId = customerId;
//	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(LocalDateTime reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Override
	public String toString() {
		return "Review [Id=" + Id + ", product=" + product.getId() + ", customer=" + customer.getId() + ", rating=" + rating
				+ ", comment=" + comment + ", reviewDate=" + reviewDate + "]";
	}

	public Object getYourBooleanField() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
