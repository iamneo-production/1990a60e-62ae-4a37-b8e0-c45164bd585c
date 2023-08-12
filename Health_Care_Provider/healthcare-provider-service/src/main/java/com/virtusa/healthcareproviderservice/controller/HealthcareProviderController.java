package com.virtusa.healthcareproviderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.healthcareproviderservice.entities.HealthCareProvider;
import com.virtusa.healthcareproviderservice.exception.SuccessModel;
import com.virtusa.healthcareproviderservice.service.HealthcareProviderService;

@RestController
public class HealthcareProviderController {
@Autowired
private HealthcareProviderService service ;

@GetMapping(value = "/api/providers", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<HealthCareProvider>> getListOfProviders()
{
	return new ResponseEntity<>(service.getListOfHealthCareProviders(),HttpStatus.OK);
}

@PostMapping(value = "/api/providers", consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<SuccessModel> saveProviders(@RequestBody HealthCareProvider healthcaresProvider)
{
	SuccessModel successModel=new SuccessModel();
	successModel.setMessage(service.saveHealthcareProvider(healthcaresProvider));
	return new ResponseEntity<>(successModel,HttpStatus.CREATED);
}
}
