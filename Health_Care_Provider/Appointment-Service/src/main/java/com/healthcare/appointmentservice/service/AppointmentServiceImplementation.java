package com.healthcare.appointmentservice.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.healthcare.appointmentservice.entity.Appointment;
import com.healthcare.appointmentservice.feign.HealthcareProviderFeign;
import com.healthcare.appointmentservice.repository.AppointmentRepository;
import com.healthcare.appointmentservice.request.AppointmentRequest;
import com.healthcare.appointmentservice.request.HealthcareProvider;
import com.healthcare.appointmentservice.request.HealthcareProviderRequest;

@Service
public class AppointmentServiceImplementation implements AppointmentService {

	private AppointmentRepository appointmentRepository;
	private HealthcareProviderFeign healthcareProviderFeign;

	@Autowired
	public AppointmentServiceImplementation(AppointmentRepository appointmentRepository,
			HealthcareProviderFeign healthcareProviderFeign) {
		super();
		this.appointmentRepository = appointmentRepository;
		this.healthcareProviderFeign = healthcareProviderFeign;
	}

	@Override
	public Appointment createAppointment(AppointmentRequest appointmentRequest) {
		if(hasAppointmentConflict(appointmentRequest.getProviderId(), appointmentRequest.getPatientId(),appointmentRequest.getAppointmentDate()) {
			throw new RuntimeException("Appointment conflict detected with another patient.");
		}
		Appointment appointment = new Appointment(1, appointmentRequest.getPatientId(),
				appointmentRequest.getProviderId(), appointmentRequest.getAppointmentDate(),
				appointmentRequest.getAppointmentTime(), appointmentRequest.getReason(), "Created");
		return appointmentRepository.save(appointment);
	}

	@Override
	public List<HealthcareProvider> getHealthcareProvidersBySpecializationAndDate(
			HealthcareProviderRequest healthcareProviderRequest) {
		List<HealthcareProvider> providersList = healthcareProviderFeign
				.getAllHealthcareProvidersBySpecializationAndDate(healthcareProviderRequest);
		if (providersList.isEmpty()) {
			throw new RuntimeException("No available providers found.");
		}
		return providersList;
	}

	private boolean hasAppointmentConflict(int providerId, int patientId, LocalDate appointmentDate) {
		List<Appointment> appointments = appointmentRepository.findAllAppointmentsByProviderIdAndAppointmentDateTime(providerId,
				appointmentDate);
		if(appointments.isEmpty()) {
			return false;
		}
		else {
			return appointments.stream().anyMatch(appointment -> !appointment.getPatientId().equals(patientId));
		}
	}

//	private boolean isProviderAvailable(HealthcareProvider provider, LocalDate appointmentDate,
//			LocalTime appointmentTime) {
//		LocalTime availableStartTime = provider.getAvailableStartTime();
//		LocalTime availableEndTime = provider.getAvailableEndTime();
//		return appointmentTime.isAfter(availableStartTime) && appointmentTime.isBefore(availableEndTime);
//	}
}
