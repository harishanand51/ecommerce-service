package com.uga.ecommerce.service.impl;



import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;

import com.uga.ecommerce.entity.PaymentTransaction;
import com.uga.ecommerce.entity.Product;
import com.uga.ecommerce.entity.Review;
import com.uga.ecommerce.repo.CustomerRepo;
import com.uga.ecommerce.repo.ProductRepo;
import com.uga.ecommerce.repo.PaymentTransactionRepo;

import com.uga.ecommerce.service.PaymentTransactionService;


@Service
public class PaymentTransactionServiceImpl implements PaymentTransactionService {

	@Autowired
	PaymentTransactionRepo paymentTransactionRepo;
	
	@Autowired
    ProductRepo productRepo;

    @Autowired
    CustomerRepo customerRepo;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
	public PaymentTransaction addPaymentTransaction(PaymentTransaction paymentTransaction){
		
    	PaymentTransaction rw = paymentTransactionRepo.save(paymentTransaction);
		
		return rw;
	}
	
    
}