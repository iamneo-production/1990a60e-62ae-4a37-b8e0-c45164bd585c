package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Patient {
	
	@Id
	private int patientId;
    private String patientName;
    private int age;
    private String phoneno;
    private String address;
    private String disease;
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public Patient(int patientId, String patientName, int age, String phoneno, String address, String disease) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
		this.phoneno = phoneno;
		this.address = address;
		this.disease = disease;
	}
    
    

}
