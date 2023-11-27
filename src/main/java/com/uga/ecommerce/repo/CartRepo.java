package com.uga.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uga.ecommerce.entity.Cart;

public interface CartRepo extends JpaRepository<Cart, Long> {
	
	@Query("SELECT MAX(e.id) FROM Cart e")
    Long findMaxId();

}
