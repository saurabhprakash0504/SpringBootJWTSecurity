package com.sapient.security.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.security.model.JWTUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JWTValidator {

	@Autowired
	JWTUser jwtUser;
	
	private String secret="youtube";
	
	public JWTUser validate(String stoken) {
		try {
		Claims body=Jwts.parser()
				.setSigningKey(secret)
				.parseClaimsJws(stoken)
				.getBody();
		 jwtUser.setUserName(body.getSubject());;
		 jwtUser.setId(Long.parseLong((String)body.get("userId")));
		 jwtUser.setRole((String)body.get("role"));
		 
		  
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return jwtUser;
	}

}
