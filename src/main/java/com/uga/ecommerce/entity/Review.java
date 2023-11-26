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
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="product_id", nullable = false)
	@JsonIgnore
	private Product product;
	
	/*@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="customer_id",  nullable=false)
	@JsonIgnore
	private Customer customer;*/
	
	@Column(name="rating")
	private int rating;
	
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	/*public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}*/

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
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
		return "Review [Id=" + Id + ", product=" + product +  ", rating=" + rating
				+ ", comment=" + comment + ", reviewDate=" + reviewDate + "]";
	}

	
	

}
