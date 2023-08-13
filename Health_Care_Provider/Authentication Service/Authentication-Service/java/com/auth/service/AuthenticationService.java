package com.auth.service;

import java.util.Base64;
import java.util.Date;

import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthenticationService {

	// Replace this with your own secret key for token signing
	private static final String SECRET_KEY = "sudheer4013";

	public String authenticate(String username, String password) {
		// Logic to validate the credentials against the database
		boolean isValidCredentials = validateCredentials(username, password);

		if (isValidCredentials) {
			// If the credentials are valid, generate and return a JWT
			String jwtToken = generateJwtToken(username);
//			jwtToken=generateShortToken(jwtToken);
			System.out.println(jwtToken);
			AuthorizationService authorizationService = new AuthorizationService();
			boolean res=authorizationService.isAuthorized(jwtToken);
			System.out.println(res);
			return jwtToken;
		}

		// Return null or an error message if authentication fails
		return null;
	}

	private boolean validateCredentials(String username, String password) {
		// Logic to validate the credentials against the database
		// Implement your own authentication logic here
		// For this example, we'll assume all credentials are valid
		return true;
	}

	private String generateJwtToken(String username) {
		// Logic to generate a JWT token with username and other necessary information
		long expirationTimeInMillis = 3600000; // 1 hour (adjust as needed)
		Date expirationDate = new Date(System.currentTimeMillis() + expirationTimeInMillis);

		String jwtToken = Jwts.builder().setSubject(username).setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();

		return jwtToken;
	}

}
