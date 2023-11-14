package com.uga.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uga.ecommerce.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long>  {
	
	List<Product> findByProductName(String name);

}
