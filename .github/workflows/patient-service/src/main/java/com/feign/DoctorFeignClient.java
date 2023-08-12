package com.hackathon.feign;

 

import org.springframework.cloud.openfeign.FeignClient;

 

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import com.hackathon.entity.Appointment;

 

@FeignClient(name = "DOCTOR-SERVICE")
public interface DoctorFeignClient {

 

    @GetMapping("doctor/appointments/{patientId}")
    public List<Appointment> gettingAppointments(@PathVariable("patientId") int pid);

}
