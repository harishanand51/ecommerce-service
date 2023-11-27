package com.uga.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uga.ecommerce.entity.ProductCart;
import com.uga.ecommerce.entity.ProductCartKey;

public interface ProductCartRepo extends JpaRepository<ProductCart, ProductCartKey> {

	ProductCart findByCartIdAndProductId(Long cartId, Long productId);

	

	List<ProductCart> findByCartId(Long cartId);


}
