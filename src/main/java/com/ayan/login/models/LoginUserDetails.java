package com.ayan.login.models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired;
	private boolean isEnable;
	private Collection<? extends GrantedAuthority> authorities;

	public LoginUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		this.username = username;
		this.password = password;
		this.isAccountNonExpired = true;
		this.isAccountNonLocked = true;
		this.isEnable = true;
		this.isCredentialsNonExpired = true;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return isEnable;
	}

}
