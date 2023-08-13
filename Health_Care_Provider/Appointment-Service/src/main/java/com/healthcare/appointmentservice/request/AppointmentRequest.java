package com.healthcare.appointmentservice.request;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentRequest {
	
    private int patientId;
    private int providerId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String reason;
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public AppointmentRequest(int patientId, int providerId, LocalDate appointmentDate, LocalTime appointmentTime,
			String reason) {
		super();
		this.patientId = patientId;
		this.providerId = providerId;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.reason = reason;
	}
	public AppointmentRequest() {
		super();
	}
	@Override
	public String toString() {
		return "AppointmentRequest [patientId=" + patientId + ", providerId=" + providerId + ", appointmentDate="
				+ appointmentDate + ", appointmentTime=" + appointmentTime + ", reason=" + reason + "]";
	}
}
