package com.healthcare.appointmentservice.request;

import java.time.LocalDate;

public class HealthcareProviderRequest {
	
	private String Specialization;
	private LocalDate appointmentDate;
	
	public HealthcareProviderRequest(String specialization, LocalDate appointmentDate) {
		super();
		Specialization = specialization;
		this.appointmentDate = appointmentDate;
	}
	public HealthcareProviderRequest() {
		super();
	}
	public String getSpecialization() {
		return Specialization;
	}
	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	@Override
	public String toString() {
		return "HealthcareProviderRequest [Specialization=" + Specialization + ", appointmentDate=" + appointmentDate
				+ "]";
	}
}
