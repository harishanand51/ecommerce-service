package com.uga.ecommerce.service;

import java.util.List;

import com.uga.ecommerce.entity.Product;

public interface ProductService {
	
	public List<Product> getProductByName(String name);
	
	public Product getProductById(Long productId);
	
	public Product addProduct(Product product);
	
	public void deleteProduct(Long productId);
	
	public Product editProduct(Product product);
	
	

}
