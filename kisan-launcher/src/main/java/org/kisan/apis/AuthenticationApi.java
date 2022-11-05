package org.kisan.apis;

import org.kisan.dto.beans.AuthenticationRequest;
import org.kisan.dto.beans.AuthenticationResponse;
import org.kisan.exceptions.UserNotValidException;
import org.kisan.exceptions.UserValidationException;
import org.kisan.security.util.AuthenticationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authenticate")
public class AuthenticationApi {

	private AuthenticationManager authenticationManager;
	private AuthenticationUtil authUtil;
	//private UserAuthService authService;
	
	public AuthenticationApi(AuthenticationUtil authUtil, AuthenticationManager authManager) {
		this.authUtil = authUtil;
		//this.authService = authService;
		this.authenticationManager = authManager;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest) throws Exception {

		try {
			
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
			);
			
		} catch (BadCredentialsException ex) {
			throw new UserNotValidException("Incorrect username or password");
		} catch (Exception ex) {
			throw new UserValidationException("Not able to validate username or password");
		}

		/*
		final UserDetails userDetails = authService
				.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));*/
		
		final String authToken = authUtil.generateTokenUsingUsername(authRequest.getUsername());
		
		return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse(authToken), HttpStatus.CREATED);
	}
}
