package com.uga.ecommerce.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uga.ecommerce.entity.Category;
import com.uga.ecommerce.entity.Product;
import com.uga.ecommerce.entity.ProductCategory;
import com.uga.ecommerce.repo.ProductCategoryRepo;
import com.uga.ecommerce.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	
	
	@Autowired
	ProductCategoryRepo productCategoryRepo;

	@Override
	public ProductCategory addProductToCategory(ProductCategory productCategory) {
		
		//ProductCategory productCategory = new ProductCategory();
		
		//productCategory.setProduct(product);
		//productCategory.setCategory(category);
		
		productCategoryRepo.save(productCategory);
		
		return productCategory;
	}

	@Override
	public boolean isProductMappedToCategory(Product product, Category category) {
		
		return productCategoryRepo.existsByProductAndCategory(product, category);
	}

	@Override
	public List<Product> getAllProductsinCategory(Category category) {
		
		
		List<ProductCategory> productCategories = productCategoryRepo.findByCategory(category);
		
		/*return productCategories.stream()
                .map(ProductCategory::getProduct)
                .collect(Collectors.toList());*/
		
		return productCategories.stream()
                .map(productCategory -> productCategory.getId().getProduct())
                .collect(Collectors.toList());
		
	}

	@Override
	@Transactional
	public void removeProductfromCategory(Product product, Category category) {
		
		productCategoryRepo.deleteByProductAndCategory(product,category);
		
	}

}
