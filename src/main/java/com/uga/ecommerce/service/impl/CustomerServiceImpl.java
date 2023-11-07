package com.uga.ecommerce.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.uga.ecommerce.entity.Customer;
import com.uga.ecommerce.repo.CustomerRepo;
import com.uga.ecommerce.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Customer getCustomerById(Long id) {
		
		Optional<Customer> customer = customerRepo.findById(id);
		
		return customer.get();
	}

	@Override
	public Optional<Customer> getCustomerByEmail(String email) {
		
		return customerRepo.findByEmail(email);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		
		customerRepo.save(customer);
		
		return customer;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<Customer> customer = customerRepo.findByEmail(email);
		
		if (customer.isEmpty()) {
			throw new UsernameNotFoundException(String.format("No record present for email: %s", email));
		}
		
		return customer.get();
	}

	@Override
	public Customer editProfileDetails(Customer currentCustomer, Customer reqCustomer) {
		
		currentCustomer = getCustomerById(currentCustomer.getId());
		
		if (reqCustomer.getFirstName() != null)
			currentCustomer.setFirstName(reqCustomer.getFirstName());
		
		if (reqCustomer.getLastName() != null)
			currentCustomer.setLastName(reqCustomer.getLastName());
		
		if (reqCustomer.getFirstName() != null)
			currentCustomer.setFirstName(reqCustomer.getFirstName());
		
		if (reqCustomer.getPhone() != null)
			currentCustomer.setPhone(reqCustomer.getPhone());
		
		if (reqCustomer.getAddress() != null)
			currentCustomer.setAddress(reqCustomer.getAddress());
		
		if (reqCustomer.getPassword() != null)
			currentCustomer.setPassword(passwordEncoder.encode(reqCustomer.getPassword()));
		
		currentCustomer = customerRepo.save(currentCustomer);
		
		return currentCustomer;
	}

}
