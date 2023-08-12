package com.virtusa.healthcareproviderservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.healthcareproviderservice.entities.HealthCareProvider;
@Repository
public interface HealthcareProviderRepository extends JpaRepository<HealthCareProvider, Long> {

}
