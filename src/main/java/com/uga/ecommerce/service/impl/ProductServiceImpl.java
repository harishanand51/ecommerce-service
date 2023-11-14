package com.uga.ecommerce.service.impl;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uga.ecommerce.entity.Product;
import com.uga.ecommerce.repo.ProductRepo;
import com.uga.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepo productRepo;

	@Override
	public List<Product> getProductByName(String name) {
		
		return productRepo.findByProductName(name);
	}
	
	@Override
	public Product getProductById(Long id) {
		
		Optional<Product> product = productRepo.findById(id);
		
		return product.get();
	}

	@Override
	@Transactional
	public Product addProduct(Product product) {
		
		product = productRepo.save(product);
		
		return product;
	}

	@Override
	public void deleteProduct(Long productId) {
		
		productRepo.deleteById(productId);
		
	}


	@Override
	@Transactional
	public Product editProduct(Product product) {
		
		Product existingProduct = getProductById(product.getId());
		
		if(product.getProductName() != null)
			existingProduct.setProductName(product.getProductName());
		
		if(product.getDescription() != null)
			existingProduct.setDescription(product.getDescription());
		
		if(product.getPrice() != null)
			existingProduct.setPrice(product.getPrice());
		
		if(product.getStockQuantity() != null)
			existingProduct.setStockQuantity(product.getStockQuantity());
		
		existingProduct = productRepo.save(existingProduct);
		
		return product;
	}

	
	
	
}
