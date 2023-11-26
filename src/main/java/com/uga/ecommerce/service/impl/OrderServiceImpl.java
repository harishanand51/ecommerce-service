package com.uga.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uga.ecommerce.entity.Customer;
import com.uga.ecommerce.entity.Order;
import com.uga.ecommerce.entity.Product;
import com.uga.ecommerce.repo.CustomerRepo;
import com.uga.ecommerce.repo.OrderRepo;
import com.uga.ecommerce.repo.ProductRepo;
import com.uga.ecommerce.service.OrderService;


//@Service

//public class OrderServiceImpl implements OrderService {
//	
//	@Autowired
//	CustomerRepo customerRepo;
//	
//	@Autowired
//	ProductRepo productRepo;
//	
//	@Autowired
//	OrderRepo orderRepo;
//	
//	@Override
//	public void addProductToCart(Long customerId, Long productId) {
//		
//		Optional<Customer> reqCustomer = customerRepo.findById(customerId);
//		Optional<Product> reqProduct = productRepo.findById(productId);
//		
//		if(reqCustomer != null && reqProduct != null) {
//			
//			if(orderRepo.findByCustomer(reqCustomer)) {
//				
//				Order order = orderRepo.getByCustomer(reqCustomer);
//				List<Product> productsList = order.getProducts();
//				
//				productsList.add(reqProduct.get());
//				order.setProducts(productsList);
//				
//			}
//			else {
//				
//				Order order = new Order();
//                List<Product> productsList = order.getProducts();
//                
//                productsList.add(reqProduct.get());
//				order.setProducts(productsList);
//				
//			}
//			
//			
//		}
//		
//		
//	}

	/*@Override
	public void addProdcutToOrder(Long customerId, Long productId) {
		
		Optional<Customer> reqCustomer = customerRepo.findById(customerId);
		Optional<Product> reqProduct = productRepo.findById(productId);
		
		if(reqCustomer != null && reqProduct != null) {
			
			if(orderRepo.findByCustomer(reqCustomer)) {
				
				Order order = orderRepo.getByCustomer(reqCustomer);
				List<Product> productsList = order.getProducts();
				
				productsList.add(reqProduct.get());
				order.setProducts(productsList);
				
				orderRepo.save(order);
			}
			else {
				Order order = new Order();
                List<Product> productsList = order.getProducts();
				
				productsList.add(reqProduct.get());
				order.setProducts(productsList);
				
				orderRepo.save(order);
				
			}
			
		}
		
	}
*/
//} 

