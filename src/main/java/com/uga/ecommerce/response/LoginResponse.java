package com.uga.ecommerce.response;

import com.uga.ecommerce.entity.CustomerType;

public class LoginResponse {
	
	private String token;
	private CustomerType customerType;
	private String errMsg;


	public LoginResponse(LoginResponseBuilder responseBuilder) {
		this.token = responseBuilder.token;
		this.customerType = responseBuilder.customerType;
		this.errMsg = responseBuilder.errMsg;
	}

	public String getToken() {
		return token;
	}
	
	public CustomerType getCustomerType() {
		return customerType;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public static class LoginResponseBuilder {

		private String token;
		private CustomerType customerType;
		private String errMsg;

		public LoginResponseBuilder setToken(String token) {
			this.token = token;
			return this;
		}
		
		public LoginResponseBuilder setCustomerType(CustomerType customerType) {
			this.customerType = customerType;
			return this;
		}


		public LoginResponseBuilder setErrMsg(String errMsg) {
			this.errMsg = errMsg;
			return this;
		}
		
		

		public LoginResponse build() {
			return new LoginResponse(this);
		}
	}

}
