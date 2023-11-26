package com.uga.ecommerce.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
public enum Category{
	
	Fashion, Electroncis, Food, Household, Cosmetics, Groceries, Sports, Furniture, Stationaries, Medicine
	
}
*/

@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="category_id")
	private Long id;
	
	@Column(name="category_name")
	private String categoryName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [Id=" +id + ", categoryName=" + categoryName + "]";
	}
	
	

}
