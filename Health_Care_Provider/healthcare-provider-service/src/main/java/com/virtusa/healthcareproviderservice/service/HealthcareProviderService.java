package com.virtusa.healthcareproviderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.virtusa.healthcareproviderservice.entities.HealthCareProvider;
import com.virtusa.healthcareproviderservice.repositories.HealthcareProviderRepository;

import jakarta.transaction.Transactional;
@Service
public class HealthcareProviderService {

	@Autowired
	private HealthcareProviderRepository repository ;
	public List<HealthCareProvider> getListOfHealthCareProviders() {
		return repository.findAll();
	}
	@Transactional
	@Modifying
	public String saveHealthcareProvider(HealthCareProvider healthcareProvider) {
		HealthCareProvider provider = repository.saveAndFlush(healthcareProvider);
		return (provider != null) ? "Record inserted for the provider " + healthcareProvider.getProviderName() + " with the date " + healthcareProvider.getAvailableDate() : "Provider Unavailable";

	}

}
