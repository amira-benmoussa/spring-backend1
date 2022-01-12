package com.elcom.flux.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elcom.flux.config.JwtTokenUtil;
import com.elcom.flux.entities.Responsable;
import com.elcom.flux.requests.JwtRequest;
import com.elcom.flux.responses.JwtResponse;
import com.elcom.flux.services.UserService;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class LoginController {


	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UserService usersService;

	@PostMapping
	public JwtResponse createAuthenticationToken(@RequestBody JwtRequest user) throws Exception {

		Authentication auth = authenticate(user.getUsername(), user.getPassword());
		final Responsable userDetails = (Responsable) usersService.loadUserByUsername(user.getUsername());
		final String token = jwtTokenUtil.generateToken(auth.getName(), auth.getAuthorities());
		return new JwtResponse(token, userDetails);
	}

	private Authentication authenticate(String username, String password) throws Exception {
		try {
			Authentication auth = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			return auth;
		} catch (InternalAuthenticationServiceException e) {
			throw new InternalAuthenticationServiceException("INVALID_USERNAME", e);
		}

		catch (DisabledException e) {
			throw new DisabledException("USER_DISABLED", e);
		}

		catch (BadCredentialsException e) {
			throw new BadCredentialsException("INVALID_CREDENTIALS", e);
		}
	}
}
