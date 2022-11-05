package org.kisan.dto.beans;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String authenticationToken;

    public AuthenticationResponse(String token) {
        this.authenticationToken = token;
    }

	public String getAuthenticationToken() {
		return authenticationToken;
	}
}
