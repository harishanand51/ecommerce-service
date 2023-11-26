package com.uga.ecommerce.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ProductCartKey implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;   


    // Getters and setters

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

	@Override
	public String toString() {
		return "ProductCartKey [cart=" + cart + ", product=" + product + "]";
	}
    

    // equals() and hashCode() methods

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductCartKey that = (ProductCartKey) o;

        if (cart != null ? !cart.equals(that.cart) : that.cart != null) return false;
        return product != null ? product.equals(that.product) : that.product == null;
    }

    @Override
    public int hashCode() {
        int result = cart != null ? cart.hashCode() : 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }*/

}
