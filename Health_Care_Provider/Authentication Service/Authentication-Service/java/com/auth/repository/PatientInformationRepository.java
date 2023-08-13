package com.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.entity.PatientInformation;

public interface PatientInformationRepository extends JpaRepository<PatientInformation, Long> {

}
