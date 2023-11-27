package com.uga.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uga.ecommerce.entity.Cart;

public interface CartRepo extends JpaRepository<Cart, Long> {

	void deleteCartById(Long reqCartId);

}
