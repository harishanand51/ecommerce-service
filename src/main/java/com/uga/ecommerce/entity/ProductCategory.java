package com.uga.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_category")
public class ProductCategory {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="product_category_id")
	//private Long id;
	
	 @EmbeddedId
	 private ProductCategoryKey id;
	 
	 @OneToOne
		@JoinColumn(name="product_id", insertable = false, updatable = false)
		private Product product;
		
		@OneToOne
		@JoinColumn(name="category_id", insertable = false, updatable = false)
		private Category category;
		

	public ProductCategoryKey getId() {
		return id;
	}

	public void setId(ProductCategoryKey id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ProductCategory [id=" + id + "]";
	}
	
	/*@OneToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@OneToOne
	@JoinColumn(name="category_id")
	private Category category;
	*/

	/*public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}*/

	

	

}
