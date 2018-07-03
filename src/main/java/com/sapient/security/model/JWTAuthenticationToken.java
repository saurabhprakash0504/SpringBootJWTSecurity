package com.sapient.security.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

//This is a model class
public class JWTAuthenticationToken extends UsernamePasswordAuthenticationToken{
	
	private String token;

	public JWTAuthenticationToken(String token) {
		super(null, null);
		this.token=token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
