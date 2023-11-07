package com.uga.ecommerce.response;

public class LoginResponse {
	
	private String token;
	private String errMsg;

	public LoginResponse(String token, String errMsg) {
		this.token = token;
		this.errMsg = errMsg;
	}

	public LoginResponse(LoginResponseBuilder responseBuilder) {
		this.token = responseBuilder.token;
		this.errMsg = responseBuilder.errMsg;
	}

	public String getToken() {
		return token;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public static class LoginResponseBuilder {

		private String token;
		private String errMsg;

		public LoginResponseBuilder setToken(String token) {
			this.token = token;
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
