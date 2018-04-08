package com.eccweb.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.eccweb.entity.Account;
import com.eccweb.security.UserAuthentication;
import com.eccweb.security.UserDetailsServiceImpl;
import com.eccweb.service.impl.TokenAuthenticationService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StatelessLoginFilter extends AbstractAuthenticationProcessingFilter {

	private final TokenAuthenticationService tokenAuthenticationService;
	private final UserDetailsServiceImpl userDetailsService;

	public StatelessLoginFilter(String urlMapping, TokenAuthenticationService tokenAuthenticationService,
			UserDetailsServiceImpl userDetailsService, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(urlMapping,HttpMethod.POST.toString()));
		this.userDetailsService = userDetailsService;
		this.tokenAuthenticationService = tokenAuthenticationService;
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		//String theString = IOUtils.toString(request.getInputStream(), "UTF-8"); 
		//final Account user = new ObjectMapper().readValue(request.getInputStream(), Account.class);
		
		String user = request.getParameter("name");
		String password = request.getParameter("password");
		final UsernamePasswordAuthenticationToken loginToken = new UsernamePasswordAuthenticationToken(
				user, password);
		return getAuthenticationManager().authenticate(loginToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			FilterChain chain, Authentication authentication) throws IOException, ServletException {

		// Lookup the complete User object from the database and create an Authentication for it
		final Account authenticatedUser = userDetailsService.loadUserByUsername(authentication.getName());
		final UserAuthentication userAuthentication = new UserAuthentication(authenticatedUser);

		// Add the custom token as HTTP header to the response
		tokenAuthenticationService.addAuthentication(response, userAuthentication);

		// Add the authentication to the Security context
		SecurityContextHolder.getContext().setAuthentication(userAuthentication);
	}
}