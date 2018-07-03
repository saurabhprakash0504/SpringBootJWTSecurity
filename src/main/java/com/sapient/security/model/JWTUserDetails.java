package com.sapient.security.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JWTUserDetails implements UserDetails {

	private String userName;
	private long id;
	private String token;
	private Collection<? extends GrantedAuthority> granted;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Collection<? extends GrantedAuthority> getGranted() {
		return granted;
	}

	public void setGranted(Collection<? extends GrantedAuthority> granted) {
		this.granted = granted;
	}

	public JWTUserDetails(String userName, long id, String token, List<GrantedAuthority> granted) {
		this.userName = userName;
		this.id = id;
		this.token = token;
		this.granted = granted;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return granted;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	/*
	 * @Override public Collection<? extends GrantedAuthority> getAuthorities() { //
	 * TODO Auto-generated method stub return null; }
	 * 
	 * @Override public String getPassword() { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public String getUsername() { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public boolean isAccountNonExpired() { // TODO Auto-generated
	 * method stub return false; }
	 * 
	 * @Override public boolean isAccountNonLocked() { // TODO Auto-generated method
	 * stub return false; }
	 * 
	 * @Override public boolean isCredentialsNonExpired() { // TODO Auto-generated
	 * method stub return false; }
	 * 
	 * @Override public boolean isEnabled() { // TODO Auto-generated method stub
	 * return false; }
	 */
}
