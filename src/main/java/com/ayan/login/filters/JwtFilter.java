package com.ayan.login.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ayan.login.services.JwtService;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtService jwtService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String ah = request.getHeader("Authorization");
		String u = null;
		String jwt = null;
		if (ah != null && ah.startsWith("Bearer ")) {
			jwt = ah.substring(7);
			u = jwtService.extractUsername(jwt);
		}
		if (u != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails ud = userDetailsService.loadUserByUsername(u);
			if (jwtService.validateToken(jwt, ud)) {
				UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(ud, null,
						ud.getAuthorities());
				upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(upat);
			}
		}
		filterChain.doFilter(request, response);
	}

}
