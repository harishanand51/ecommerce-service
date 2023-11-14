package com.uga.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uga.ecommerce.entity.Category;
import com.uga.ecommerce.entity.Product;
import com.uga.ecommerce.repo.CategoryRepo;
import com.uga.ecommerce.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepo categoryRepo;

	@Override
	public List<Category> getAllCategories() {
		
		return null;
				//categoryRepo.findAll();
	}

	@Override
	public Category getcategoryById(Long categoryId) {
		
		Optional<Category> category = categoryRepo.findById(categoryId);
		
		return category.get();
	}
	
	@Override
	@Transactional
	public Category addCategory(Category category) {
		
		category = categoryRepo.save(category);
		
		return category;
	}

	

}
