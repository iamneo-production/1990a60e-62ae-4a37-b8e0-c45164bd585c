package com.healthcare.appointmentservice.request;

import java.math.BigInteger;
import java.time.LocalTime;

public class HealthcareProvider {
	
	private int id;

    private String name;
    private String specialization;
    private LocalTime availableStartTime;
    private LocalTime availableEndTime;
    private boolean available;
    private String address;
    private BigInteger contact;
    private String email;
	public HealthcareProvider(int id, String name, String specialization, LocalTime availableStartTime,
			LocalTime availableEndTime, boolean available, String address, BigInteger contact, String email) {
		super();
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		this.availableStartTime = availableStartTime;
		this.availableEndTime = availableEndTime;
		this.available = available;
		this.address = address;
		this.contact = contact;
		this.email = email;
	}
	public HealthcareProvider() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public LocalTime getAvailableStartTime() {
		return availableStartTime;
	}
	public void setAvailableStartTime(LocalTime availableStartTime) {
		this.availableStartTime = availableStartTime;
	}
	public LocalTime getAvailableEndTime() {
		return availableEndTime;
	}
	public void setAvailableEndTime(LocalTime availableEndTime) {
		this.availableEndTime = availableEndTime;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BigInteger getContact() {
		return contact;
	}
	public void setContact(BigInteger contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "HealthcareProvider [id=" + id + ", name=" + name + ", specialization=" + specialization
				+ ", availableStartTime=" + availableStartTime + ", availableEndTime=" + availableEndTime
				+ ", available=" + available + ", address=" + address + ", contact=" + contact + ", email=" + email
				+ "]";
	}
    
    
}
