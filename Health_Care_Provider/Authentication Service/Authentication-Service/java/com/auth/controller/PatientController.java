package com.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.entity.LoginRequest;
import com.auth.entity.PatientInfoRequest;
import com.auth.service.AuthenticationService;
import com.auth.service.AuthorizationService;

@RestController
public class PatientController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // Call the AuthenticationService to validate credentials and get a JWT token
        String jwtToken = authenticationService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        return jwtToken;
    }

    @PostMapping("/patient/info")
    public String getPatientInfo(@RequestBody PatientInfoRequest patientInfoRequest) {
    	
        // Validate the JWT token received in the request
        if (!authorizationService.isAuthorized(patientInfoRequest.getJwtToken())) {
            return "Unauthorized";
        }

        // Check if the user has access to view patient information
        if (!authorizationService.hasAccess(patientInfoRequest.getJwtToken())) {
            return "Access Denied";
        }

        // Logic to retrieve patient information from a secure database
        // and return the information as a response
        String patientInfo = null;
        //fetchPatientInfo(patientInfoRequest.getPatientId());
        return patientInfo;
    }


}

