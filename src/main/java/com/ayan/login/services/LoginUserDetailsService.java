package com.ayan.login.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ayan.login.models.LoginUserDetails;
import com.ayan.login.models.User;
import com.ayan.login.repositories.UserRepository;

@Service
public class LoginUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = userRepository.findById(username)
				.orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s Not Found", username)));
		return new LoginUserDetails(u.getId(), u.getPassword(),
				Arrays.asList(new SimpleGrantedAuthority(String.format("ROLE_%s", u.getRol().getDescription()))));
	}

}
