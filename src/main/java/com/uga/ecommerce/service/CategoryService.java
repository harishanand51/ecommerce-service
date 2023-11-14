package com.uga.ecommerce.service;

import java.util.List;

import com.uga.ecommerce.entity.Category;
import com.uga.ecommerce.entity.Product;

public interface CategoryService {
	
	public List<Category> getAllCategories();
	public Category getcategoryById(Long categoryId);
	public Category addCategory(Category category);

}
