package com.uga.ecommerce.service;

import java.util.List;

import com.uga.ecommerce.entity.Product;
import com.uga.ecommerce.response.CartResponse;

public interface CartService {

	public String addProductToCart(Long cartId, Long productId, Integer quantity);
	public String removeProductFromCart(Long cartId, Long productId);
	public List<CartResponse> getProductsInCart(Long cartId);

}
