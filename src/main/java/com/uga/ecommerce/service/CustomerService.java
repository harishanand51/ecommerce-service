package com.uga.ecommerce.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.uga.ecommerce.entity.Customer;

public interface CustomerService extends UserDetailsService {
	public Customer getCustomerById(Long id);
	public Optional<Customer> getCustomerByEmail(String email);
	public Customer saveCustomer(Customer customer);
	public Customer editProfileDetails(Customer currentCustomer, Customer reqCustomer);
	

}
