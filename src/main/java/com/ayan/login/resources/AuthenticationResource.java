package com.ayan.login.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ayan.login.models.User;
import com.ayan.login.services.JwtService;

@RestController
public class AuthenticationResource {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtService jwtService;

	@PostMapping(path = "authenticate")
	public ResponseEntity<String> createAuthenticationToken(@RequestBody User user) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getId(), user.getPassword()));
		final UserDetails ud = userDetailsService.loadUserByUsername(user.getId());
		return ResponseEntity.ok(jwtService.generateToken(ud));
	}

}
