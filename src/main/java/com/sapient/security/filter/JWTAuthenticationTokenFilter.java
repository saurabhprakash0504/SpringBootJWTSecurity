package com.sapient.security.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class JWTAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {
	
	public JWTAuthenticationTokenFilter() {
		super("/**");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		return null;
	}

/*	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		// TODO Auto-generated method stub
		
	}

	public void setAuthenticationSuccessHandler() {
		// TODO Auto-generated method stub
		
	}

	public void setAuthenticationSuccessHandler(JWTsuccessHandler jwTsuccessHandler) {
		// TODO Auto-generated method stub
		
	}*/

}
