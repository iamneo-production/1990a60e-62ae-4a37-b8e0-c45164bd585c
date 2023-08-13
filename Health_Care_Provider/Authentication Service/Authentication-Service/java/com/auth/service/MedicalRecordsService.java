package com.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.entity.MedicalRecord;
import com.auth.repository.MedicalRecordRepository;

@Service
public class MedicalRecordsService {

    private final MedicalRecordRepository medicalRecordRepository;

    @Autowired
    public MedicalRecordsService(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public MedicalRecord getFullMedicalRecordInfo(String patientId) {
        // Logic to retrieve the medical record info from the database based on patientId
        MedicalRecord medicalRecord = medicalRecordRepository.findByPatientId(patientId);

        if (medicalRecord != null) {
            return medicalRecord;
        } else {
            // Handle the case when the medical history for the given patient ID is not found
          //  return "Medical history not found for patient ID: " + patientId;
            return null;
        }
    }
    
    public List<MedicalRecord> getAllMedicalRecords(String patientId){
    	List<MedicalRecord> allRecords = medicalRecordRepository.findAllByPatientId(patientId);
    	System.out.println(allRecords);
    	return allRecords;
    }
}
