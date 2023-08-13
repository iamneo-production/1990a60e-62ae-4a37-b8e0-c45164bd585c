package com.healthcare.appointmentservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.healthcare.appointmentservice.entity.Appointment;
import com.healthcare.appointmentservice.request.AppointmentRequest;
import com.healthcare.appointmentservice.request.HealthcareProvider;
import com.healthcare.appointmentservice.request.HealthcareProviderRequest;
import com.healthcare.appointmentservice.service.AppointmentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
	
	private AppointmentService appointmentService;
	
	@Autowired
	public AppointmentController(AppointmentService appointmentService) {
		super();
		this.appointmentService = appointmentService;
	}

	private static final String SERVICE_NAME = "AppointmentService";
	
    @CircuitBreaker(name = SERVICE_NAME, fallbackMethod = "defaultServiceProvidersAvailable")
    @GetMapping("/checkAvailability")
    public List<HealthcareProvider> checkProviderAvailability(@RequestBody HealthcareProviderRequest healthcareProviderRequest){
        return appointmentService.getHealthcareProvidersBySpecializationAndDate(healthcareProviderRequest);
    }

    @PostMapping("/")
    public Appointment scheduleAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        return appointmentService.createAppointment(appointmentRequest);
    }
    
}
