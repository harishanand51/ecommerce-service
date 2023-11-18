package com.uga.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uga.ecommerce.entity.ProductCart;

public interface ProductCartRepo extends JpaRepository<ProductCart, Long> {

	ProductCart findByCartIdAndProductId(Long cartId, Long productId);


}
