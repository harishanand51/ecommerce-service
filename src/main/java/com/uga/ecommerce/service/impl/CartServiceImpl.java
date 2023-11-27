package com.uga.ecommerce.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uga.ecommerce.entity.Cart;
import com.uga.ecommerce.entity.Product;
import com.uga.ecommerce.entity.ProductCart;
import com.uga.ecommerce.entity.ProductCartKey;
import com.uga.ecommerce.repo.CartRepo;
import com.uga.ecommerce.repo.ProductCartRepo;
import com.uga.ecommerce.repo.ProductRepo;

import com.uga.ecommerce.response.CartResponse;
import com.uga.ecommerce.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepo cartRepo;

	@Autowired
	ProductRepo productRepo;

	@Autowired
	ProductCartRepo productCartRepo;
	
	@SuppressWarnings("null")
	@Override
	public List<CartResponse> getProductsInCart(Long cartId) {
		
		List<ProductCart> productCarts = productCartRepo.findByCartId(cartId);
		
		List<Product> products = new ArrayList<>();
		List<Integer> quantities = new ArrayList<>();
		
		List<CartResponse> cartResponses = new ArrayList<>();
		
		for(ProductCart pc: productCarts) {
			
			CartResponse cartResponse = new CartResponse(pc.getProduct(), pc.getQuantity());
			
			cartResponses.add(cartResponse);
		}
		
		
		return cartResponses;
		
	}

	@Override
	public String addProductToCart(Long cartId, Long productId, Integer quantity) {

		Cart cart;
		float price;

		Optional<Cart> reqCart = cartRepo.findById(cartId);
		Optional<Product> reqProduct = productRepo.findById(productId);

		// check the cart is already present else create new one
		if (reqCart.isPresent()) {
			cart = reqCart.get();

		} else {
			cart = new Cart();
			cart = cartRepo.save(cart);
		}

		Product product = reqProduct.get();
		int quantityLeft = product.getStockQuantity();

		// check if the customer entered quantity exceeds the stock quantity
		if (quantity > quantityLeft) {
			return "Product quantity exceeds the stock left";
		}

		// if new cart is created create new list and add
		// else append to the existing list
		if (reqProduct.isPresent()) {

			// boolean productExistsInCart = cart.getProducts().stream()
			// .anyMatch(pc -> pc.getProduct().getId().equals(productId));
			if(cart.getProducts()==null){
				
				/*ProductCart productCart = new ProductCart();
				productCart.setCart(cart);
				productCart.setProduct(product);
				productCart.setQuantity(quantity); */
				
				ProductCartKey productCartKey = new ProductCartKey();
				productCartKey.setCart(cart);
				productCartKey.setProduct(product);
		        ProductCart productCart = new ProductCart();
		        productCart.setId(productCartKey);
		        productCart.setQuantity(quantity);

				productCart = productCartRepo.save(productCart);

				List<ProductCart> pc = new ArrayList<ProductCart>();
				pc.add(productCart);
				//cart.getProducts().add(productCart);
				cart.setProducts(pc);
				cart.setCartTotal((quantity * product.getPrice()));
				cartRepo.save(cart);
				
			}
			else {
				
				boolean productExistsInCart = false;
				for (ProductCart pc : cart.getProducts()) {
					if (pc.getProduct().getId().equals(productId)) {
						productExistsInCart = true;
						break;
					}
				}
				
				//if (!productExistsInCart) {
					ProductCartKey productCartKey = new ProductCartKey();
					productCartKey.setCart(cart);
					productCartKey.setProduct(product);
					ProductCart productCart = new ProductCart();
					productCart.setId(productCartKey);
					productCart.setQuantity(quantity);
					
					productCart = productCartRepo.save(productCart);

					cart.getProducts().add(productCart);
					cart.setCartTotal(cart.getCartTotal() + (quantity * product.getPrice())); 
					
					cartRepo.save(cart);
			//	} //else {

					//return "Product already present in the cart";
				//}
				
			}
			
			//common
			

		} else {
			return "Product doesnot esists";
		}


		// minus the quantity from the stock quantity in product
		quantityLeft -= quantity;
		product.setStockQuantity(quantityLeft);
		productRepo.save(product);

		return "Product added to the cart successfully";
	}



	@Override
	public String removeProductFromCart(Long cartId, Long productId) {

		Cart cart;
		int quantity;

		Optional<Cart> reqCart = cartRepo.findById(cartId);
		Optional<Product> reqProduct = productRepo.findById(productId);

		// check the cart is present or not
		if (reqCart.isPresent()) {
			cart = reqCart.get();
		} else {
			return "No such cart is present";
		}

		Product product = reqProduct.get();
		int quantityLeft = product.getStockQuantity();
		
		ProductCart productCartToRemove = null;
		for (ProductCart productCart : cart.getProducts()) {
            if (productCart.getProduct().getId().equals(productId)) {
                productCartToRemove = productCart;
                break;
            }
        }
		
		if(productCartToRemove != null) {
			quantity = productCartToRemove.getQuantity();
			 cart.getProducts().remove(productCartToRemove);
			 //float price = (cart.getCartTotal()) - (quantity * product.getPrice());
             cart.setCartTotal(cart.getCartTotal() - (quantity * product.getPrice())); // Recalculate total if needed
             cartRepo.save(cart);
             productCartRepo.delete(productCartToRemove);
		}
		else {
			return "Product not found in the cart";
		}
		
		quantityLeft += quantity;
		product.setStockQuantity(quantityLeft);
		productRepo.save(product);

		return "Product removed from the cart successfully";
	}

	@Override
	public Long countCarts() {
		
		return cartRepo.findMaxId();
		
	}



	

}
