package com.uga.ecommerce.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="payment_transaction")
public class PaymentTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="payment_transaction_id")
	private Long Id;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="order_id")
	private Order order;
	
	@Column(name="payment_date")
	private LocalDateTime paymentDate;
	
	@Column(name="payment_amount")
	private Float paymentAmount;
	
	@Column(name="payment_method")
	private String paymentMethod;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	

	
	
	
	
	
	
	
	

}
