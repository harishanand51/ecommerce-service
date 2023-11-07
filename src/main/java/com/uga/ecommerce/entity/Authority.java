package com.uga.ecommerce.entity;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
	
	private static final long serialVersionUID = 8916372827110109433L;
	
	public Authority(CustomerType customerType) {
		
		role = customerType;
	}
	
	private CustomerType role;

	public CustomerType getRole() {
		return role;
	}

	public void setRole(CustomerType role) {
		this.role = role;
	}
	
	@Override
	public String getAuthority() {
		return role.toString();
	}

}
