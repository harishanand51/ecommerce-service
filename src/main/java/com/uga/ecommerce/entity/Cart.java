package com.uga.ecommerce.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*@ManyToMany
    @JoinTable(
        name = "product_cart",
        joinColumns = @JoinColumn(name = "cart_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )*/
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductCart> products;
    
    @Column(name="cart_total")
	private Float cartTotal;

	public Float getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(Float cartTotal) {
		this.cartTotal = cartTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ProductCart> getProducts() {
		return products;
	}

	public void setProducts(List<ProductCart> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", products=" + products + ", cartTotal=" + cartTotal + "]";
	}

	

    
}