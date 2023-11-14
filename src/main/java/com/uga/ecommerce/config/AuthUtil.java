package com.uga.ecommerce.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.uga.ecommerce.entity.CustomerType;

public class AuthUtil {
	
	public static boolean authorizeAdminReuest(UsernamePasswordAuthenticationToken authObj) {
		return authObj.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(CustomerType.Admin.name()));
	}

}
