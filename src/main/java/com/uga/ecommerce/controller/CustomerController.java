package com.uga.ecommerce.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.uga.ecommerce.config.JwtTokenHelper;
import com.uga.ecommerce.entity.Customer;
import com.uga.ecommerce.response.LoginResponse;
import com.uga.ecommerce.service.CustomerService;

@RestController
public class CustomerController {
	
	Logger logger  = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/signup")
	public String showSingUpForm() {
		return "signup";
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerCustomer(@RequestBody Customer customer){
		
		logger.info("Inside registerCustomer"+ customer);
		
		if(customerService.getCustomerByEmail(customer.getEmail()).isPresent()) {
			return new ResponseEntity<>("Customer Already Present", HttpStatus.ALREADY_REPORTED);
		}
		
		customer = customerService.saveCustomer(customer);
		
		return new ResponseEntity<>("Customer Created", HttpStatus.CREATED);
		
	}
	
	@GetMapping("/login")
	public ResponseEntity<?> loginAuthentication(@RequestHeader(HttpHeaders.AUTHORIZATION) String auth) throws InvalidKeySpecException,  NoSuchAlgorithmException{
		
		logger.info("Inside loginAuthentication"+ auth);

		String authReq = new String(Base64.getDecoder().decode(auth.substring(6)));
		String email = authReq.split(":")[0];
		String password = authReq.split(":")[1];
		
		final Authentication authentication = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		Customer customer = (Customer) authentication.getPrincipal();
		
		String token = jwtTokenHelper.generateToken(customer.getEmail());
		
		return new ResponseEntity<>(new LoginResponse.LoginResponseBuilder().setToken(token).build(), HttpStatus.OK);
		
	}
	
	@GetMapping("/profile")
	public ResponseEntity<?> getProfile(UsernamePasswordAuthenticationToken authObj){
		
		logger.info("Inside getProfile"+ authObj);
		
		if (!authObj.isAuthenticated()) {
			return new ResponseEntity<>(
					new LoginResponse.LoginResponseBuilder().setErrMsg("Invalid credentails").build(),
					HttpStatus.UNAUTHORIZED);
		}
		
		Customer customer = (Customer) authObj.getPrincipal();
		customer = customerService.getCustomerById(customer.getId());
		
		return new ResponseEntity<>(customer, HttpStatus.OK);
		
	}
	
	@PostMapping("/profile")
	public ResponseEntity<?> editProfile(@RequestBody Customer reqCustomer, UsernamePasswordAuthenticationToken authObj){
		
		logger.info("Inside editProfile"+ reqCustomer);
		
		Customer principal = (Customer) authObj.getPrincipal();
		
		Customer customer = customerService.editProfileDetails(principal, reqCustomer);
		
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	

}
