package com.uga.ecommerce.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtTokenFilter extends OncePerRequestFilter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	public JwtTokenFilter(UserDetailsService userDetailsService, JwtTokenHelper jwtTokenHelper) {
		this.userDetailsService = userDetailsService;
		this.jwtTokenHelper = jwtTokenHelper;

	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String jwtToken = jwtTokenHelper.getToken(request);
		
		if(null != jwtToken) {
			
			String customer = jwtTokenHelper.getUsernameFromToken(jwtToken);
			
			if(null != customer) {
				
				UserDetails userDetails = userDetailsService.loadUserByUsername(customer);

				if (jwtTokenHelper.validateToken(jwtToken, userDetails)) {

					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					authentication.setDetails(new WebAuthenticationDetails(request));

					SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}		
		
	  }
	  filterChain.doFilter(request, response);
	}
	
	

}
