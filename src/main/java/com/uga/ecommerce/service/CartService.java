package com.uga.ecommerce.service;

public interface CartService {

	public String addProductToCart(Long cartId, Long productId, Integer quantity);
	public String removeProductFromCart(Long cartId, Long productId);

}
