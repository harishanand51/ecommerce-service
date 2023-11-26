package com.uga.ecommerce.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uga.ecommerce.entity.Customer;
import com.uga.ecommerce.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {

	boolean findByCustomer(Optional<Customer> reqCustomer);

	Order getByCustomer(Optional<Customer> reqCustomer);

}
