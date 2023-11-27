package com.uga.ecommerce.response;

import com.uga.ecommerce.entity.Product;

public class CartResponse {
	
	private Product product;
	private Integer quantity;
	
	public CartResponse(Product product, Integer quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartResponse [product=" + product + ", quantity=" + quantity + "]";
	}
	
	

}
