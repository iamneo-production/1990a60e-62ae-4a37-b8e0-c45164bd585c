package com.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.auth.entity.MedicalRecord;
import com.auth.entity.PatientInformation;
import com.auth.service.AuthenticationService;
import com.auth.service.AuthorizationService;
import com.auth.service.MedicalRecordsService;
import com.auth.service.PatientInformationService;

@RestController
public class HealthcareProviderController {

	private final AuthenticationService authenticationService;
	private final AuthorizationService authorizationService;
	private final PatientInformationService patientInformationService;
	private final MedicalRecordsService medicalRecordsService;

	@Autowired
	public HealthcareProviderController(AuthenticationService authenticationService,
			AuthorizationService authorizationService, PatientInformationService patientInformationService,MedicalRecordsService medicalRecordsService) {
		this.authenticationService = authenticationService;
		this.authorizationService = authorizationService;
		this.patientInformationService=patientInformationService;
		this.medicalRecordsService=medicalRecordsService;
	}

	@GetMapping("/getPatientBasicInfo/{patientId}")
	public PatientInformation getPatientBasicInfo(@PathVariable long patientId,
			@RequestHeader("Authorization") String authorizationHeader) {
		// Step 1: Healthcare Provider initiates the application and attempts to access
		// a patient's medical history.

		// Step 2: The Authentication Service receives the provider's credentials and
		// verifies them.
		String jwtToken = patientInformationService.extractJwtTokenFromHeader(authorizationHeader);
		if (jwtToken == null) {
			// Handle invalid or missing authorization token
		//	return "Unauthorized: Invalid token";
			return null;
		}

		// Step 3: The Healthcare Provider's request is then sent to the Authorization
		// Service, where the access token is validated to ensure the provider has the
		// required permissions.
		if (!authorizationService.isAuthorized(jwtToken)) {
			// Handle unauthorized access
			//return "Unauthorized: Access denied";
			return null;
		}

		// Step 4: Once authorized, the Healthcare Provider's request is forwarded to
		// the Patient Information Service.
		PatientInformation basicInfo = patientInformationService.getBasicPatientInfo(patientId);

		// Step 8: The Logging Service logs the access and activity details, such as who
		// accessed the information and when, for auditing purposes.
//     String username = extractUsernameFromToken(jwtToken);
//     loggingService.logAccessDetails(username, "accessed patient basic info with ID: " + patientId);

		return basicInfo;
	}
	
	@GetMapping("/getPatientMedicalHistory/{patientId}")
	public List<MedicalRecord> getPatientMedicalHistory(@PathVariable String patientId, @RequestHeader("Authorization") String authorizationHeader) {
		// Step 1: Healthcare Provider initiates the application and attempts to access
		// a patient's medical history.

		// Step 2: The Authentication Service receives the provider's credentials and
		// verifies them.
		String jwtToken = patientInformationService.extractJwtTokenFromHeader(authorizationHeader);
		System.out.println("Afterextracting token");
		if (jwtToken == null) {
			// Handle invalid or missing authorization token
			//return "Unauthorized: Invalid token";
			return null;
		}

		// Step 3: The Healthcare Provider's request is then sent to the Authorization
		// Service, where the access token is validated to ensure the provider has the
		// required permissions.
		System.out.println("after not null");
		if (!authorizationService.isAuthorized(jwtToken)) {
			// Handle unauthorized access
			//return "Unauthorized: Access denied";
			System.out.println("not authorized");
			return null;
		}
	    // Step 6: If the Healthcare Provider needs the full medical history, they send a request to the Medical Records Service.
//	    String fullMedicalHistory = medicalRecordsService.getFullMedicalRecordInfo(patientId);
	    System.out.println("Calling service");
		List<MedicalRecord> medicalHistoryDetails = medicalRecordsService.getAllMedicalRecords(patientId);

	    // Step 8: The Logging Service logs the access and activity details.
//	    String username = extractUsernameFromToken(jwtToken);
//	    loggingService.logAccessDetails(username, "accessed full medical history with ID: " + patientId);
	    System.out.println(medicalHistoryDetails);
	    return medicalHistoryDetails;
	}



}
