package com.uga.ecommerce.repo;


import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uga.ecommerce.entity.PaymentTransaction;

public interface PaymentTransactionRepo extends JpaRepository<PaymentTransaction, Long> 
{

}
