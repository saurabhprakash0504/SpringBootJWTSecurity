package com.sapient.security.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sapient.security.filter.JWTAuthenticationEntryPoint;
import com.sapient.security.filter.JWTAuthenticationProvider;
import com.sapient.security.filter.JWTAuthenticationTokenFilter;
import com.sapient.security.filter.JWTsuccessHandler;

@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableWebSecurity
@Configuration
public class JWTSpringConfiguration extends WebSecurityConfigurerAdapter{

	private JWTAuthenticationProvider authenticationProvider;
	private JWTAuthenticationEntryPoint entryPoint;
	
	
	@Bean
	public AuthenticationManager authenticationManager() {
		return new ProviderManager(Collections.singletonList(authenticationProvider));
	}
	
	
	@Bean
	public JWTAuthenticationTokenFilter authenticationTokenFilter() {
		
		JWTAuthenticationTokenFilter filter=new JWTAuthenticationTokenFilter();
		filter.setAuthenticationManager(authenticationManager());
		filter.setAuthenticationSuccessHandler((AuthenticationSuccessHandler) new JWTsuccessHandler());
		return filter;
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("**/rest/**").authenticated()
		.and()
		.exceptionHandling().authenticationEntryPoint(entryPoint)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		
		http.headers().cacheControl();
	}
}
