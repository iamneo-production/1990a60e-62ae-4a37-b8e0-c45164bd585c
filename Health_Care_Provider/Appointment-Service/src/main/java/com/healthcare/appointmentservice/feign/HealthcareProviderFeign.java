package com.healthcare.appointmentservice.feign;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.healthcare.appointmentservice.request.HealthcareProvider;
import com.healthcare.appointmentservice.request.HealthcareProviderRequest;

@FeignClient(name="HealthcareProvider")
public interface HealthcareProviderFeign {
	
	@GetMapping("/api/providers")
	public List<HealthcareProvider> getAllHealthcareProvidersBySpecializationAndDate(@RequestBody HealthcareProviderRequest healthcareProviderRequest);
}
