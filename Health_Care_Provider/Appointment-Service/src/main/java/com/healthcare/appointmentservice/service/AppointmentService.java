package com.healthcare.appointmentservice.service;

import java.util.List;
import com.healthcare.appointmentservice.entity.Appointment;
import com.healthcare.appointmentservice.request.AppointmentRequest;
import com.healthcare.appointmentservice.request.HealthcareProvider;
import com.healthcare.appointmentservice.request.HealthcareProviderRequest;

public interface AppointmentService {
	
	public Appointment createAppointment(AppointmentRequest appointmentRequest);
	public List<HealthcareProvider> getHealthcareProvidersBySpecializationAndDate(HealthcareProviderRequest healthcareProviderRequest);
}
