package com.uga.ecommerce.service;

import com.uga.ecommerce.entity.Order;

public interface OrderService {
	
	public void addProductToCart(Long customerId, Long productId);

	public Order addOrder(Order order);
	

}
