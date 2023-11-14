package com.uga.ecommerce.service;

import java.util.List;

import com.uga.ecommerce.entity.Category;
import com.uga.ecommerce.entity.Product;
import com.uga.ecommerce.entity.ProductCategory;

public interface ProductCategoryService {
	
	public ProductCategory addProductToCategory(ProductCategory productCategory);
	public boolean isProductMappedToCategory(Product product, Category categorty);
	public List<Product> getAllProductsinCategory(Category category);
	public void removeProductfromCategory(Product product,Category category);

}
