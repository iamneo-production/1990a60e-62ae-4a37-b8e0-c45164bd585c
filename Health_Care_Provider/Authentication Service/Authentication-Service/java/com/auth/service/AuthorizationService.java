package com.auth.service;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

@Service
public class AuthorizationService {
    public boolean isAuthorized(String jwtToken) {
        // Logic to verify the JWT token
        // You can use libraries like io.jsonwebtoken.Jwts for JWT token verification
        // Example:
         try {
             Jwts.parser().setSigningKey("sudheer4013").parseClaimsJws(jwtToken);
             return true; // Token is valid
         } catch (JwtException | IllegalArgumentException e) {
             return false; // Token is invalid
         }
    }

    public boolean hasAccess(String jwtToken) {
        // Logic to check whether the user has the necessary permissions to access patient information
        // You can extract the user roles or permissions from the JWT token
        // and perform the required authorization checks.
        // For example:
        // if (userHasRequiredPermission(jwtToken, "view_patient_info")) {
        //     return true;
        // } else {
        //     return false;
        // }
        return true; // For simplicity, assume all users have access in this example
    }
}

