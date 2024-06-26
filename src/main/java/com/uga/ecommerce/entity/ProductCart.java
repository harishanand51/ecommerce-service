package com.uga.ecommerce.entity;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_cart")
public class ProductCart {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;
	
	@EmbeddedId
    private ProductCartKey id;
	
	 @ManyToOne
	 @JoinColumn(name = "cart_id",referencedColumnName= "id", insertable = false, updatable = false)
	 private Cart cart;

	 @ManyToOne
	 @JoinColumn(name = "product_id", referencedColumnName= "id",insertable = false, updatable = false)
	 private Product product;

    /*@ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    */
    
    @JoinColumn(name = "quantity")
    private Integer quantity;

	public ProductCartKey getId() {
		return id;
	}

	public void setId(ProductCartKey id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
    
   
	

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/*@Override
	public String toString() {
		return "ProductCart [cart=" + cart + ", product=" + product + ", quantity=" + quantity + "]";
	}*/
	
	
	

	

    
}
