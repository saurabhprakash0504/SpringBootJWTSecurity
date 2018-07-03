package com.sapient.security.filter;

import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.sapient.security.model.JWTAuthenticationToken;
import com.sapient.security.model.JWTUser;
import com.sapient.security.model.JWTUserDetails;

@Component
public class JWTAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider{

	private JWTValidator validator;

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return JWTAuthenticationToken.class.isAssignableFrom(arg0);
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails arg0, UsernamePasswordAuthenticationToken arg1)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected UserDetails retrieveUser(String arg0, UsernamePasswordAuthenticationToken arg1)
			throws AuthenticationException {
		
		JWTAuthenticationToken token=(JWTAuthenticationToken)arg1;
		
		String stoken=token.getToken();
		
		JWTUser user=validator.validate(stoken);
		
		if(null!=user) {
			List<GrantedAuthority> granted=AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole());
			return new JWTUserDetails(user.getUserName(),user.getId(),stoken,granted);
		}
		else {
			throw new RuntimeException("JWT Token is incorrect <<<>>>");
		}
		

	}

}
