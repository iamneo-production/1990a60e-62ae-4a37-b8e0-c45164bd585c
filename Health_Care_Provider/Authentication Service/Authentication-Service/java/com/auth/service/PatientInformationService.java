package com.auth.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.entity.PatientInformation;
import com.auth.repository.MedicalRecordRepository;
import com.auth.repository.PatientInformationRepository;

@Service
public class PatientInformationService {

    private final PatientInformationRepository patientInformationRepository;

    @Autowired
    public PatientInformationService(PatientInformationRepository patientInformationRepository) {
        this.patientInformationRepository = patientInformationRepository;
    }

		public String extractJwtTokenFromHeader(String authorizationHeader) {
			if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
				return authorizationHeader.substring(7); // Remove "Bearer " prefix to get the token
			}
			return null; // Invalid or missing authorization header
		}

		public String extractUsernameFromToken(String jwtToken) {
			// Logic to extract the username from the JWT token.
			// For example, you can use the io.jsonwebtoken library to parse the token and
			// extract the subject (username) from it.
			// Example:
			// Claims claims =
			// Jwts.parser().setSigningKey("your-secret-key").parseClaimsJws(jwtToken).getBody();
			// return claims.getSubject();
			return "sample_username"; // For simplicity, assume a fixed username in this example.
		}

		public PatientInformation getBasicPatientInfo(long patientId) {
			// TODO Auto-generated method stub
			return patientInformationRepository.findById(patientId).orElseThrow(()-> new NoSuchElementException());
		}
}
