package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
	@Autowired
    private PatientRepo patientRepo;
	
    public Patient savePatient(Patient patient){
        Patient p=patientRepo.save(patient);
        return p;

}
}
