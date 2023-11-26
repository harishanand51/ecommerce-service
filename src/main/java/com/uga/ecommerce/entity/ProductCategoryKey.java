package com.uga.ecommerce.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class ProductCategoryKey implements Serializable {
	
	   private static final long serialVersionUID = 1L;

	@OneToOne
	    @JoinColumn(name = "product_id")
	    private Product product;

	    @OneToOne
	    @JoinColumn(name = "category_id")
	    private Category category;

	    // Constructors, getters, setters

	    public ProductCategoryKey() {
	        // Default constructor
	    }

	    public ProductCategoryKey(Product product, Category category) {
	        this.product = product;
	        this.category = category;
	    }

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		@Override
		public String toString() {
			return "ProductCategoryKey [product=" + product + ", category=" + category + "]";
		}
	    
	    

}
