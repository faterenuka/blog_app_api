package com.blog.payloads;

public class JWTAuthResponse {

	private String token;

	private UserDTO user;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO userDto) {
		this.user = userDto;
	}
	
	
	
}
