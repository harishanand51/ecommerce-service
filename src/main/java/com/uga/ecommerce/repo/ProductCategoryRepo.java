package com.uga.ecommerce.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uga.ecommerce.entity.Category;
import com.uga.ecommerce.entity.Product;
import com.uga.ecommerce.entity.ProductCategory;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Long> {
	
	boolean existsByProductAndCategory(Product product, Category category);
	
	List<ProductCategory> findByCategory(Category category);
	void deleteByProductAndCategory(Product product, Category category);

}
