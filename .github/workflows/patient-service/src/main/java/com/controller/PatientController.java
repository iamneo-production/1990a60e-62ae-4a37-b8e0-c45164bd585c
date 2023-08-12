package com.hackathon.controller;

 

import java.util.List;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;

import io.github.resilience4j.retry.annotation.Retry;

import com.hackathon.entity.Patient;

import com.hackathon.entity.Appointment;

import com.hackathon.entity.Notification;

import com.hackathon.repository.PatientRepository;

import com.hackathon.feign.DoctorFeignClient;

import com.hackathon.feign.NotificationFeignClient;

 

@RestController
public class PatientController {

 

    @Autowired
    PatientRepository patientRepository;

 

    @Autowired
    DoctorFeignClient doctorFeignClient;

 

    @Autowired
    NotificationFeignClient notificationClient;

 

    @PostMapping("/patients")
    public void createPatient(@RequestBody Patient patient){

        patientRepository.save(patient);

    }


    @PostMapping("/patients/{patientId}/appointments")

    public List<Appointment> gettingAppointments(@PathVariable("patientId") int pid){

        return doctorFeignClient.gettingAppointments(pid);

    }

 

    

    @GetMapping("/patients/notifications/{patientId}")
    @Retry(name="notification", fallbackMethod="notificationFallback")

    public List<Notification> getNotifications(@PathVariable("patientId") int pid){

        return notificationClient.notifications(pid);

    }

 

    public List<Notification> notificationFallback(){

        List<Notification> notifys=new ArrayList<>();

        Notification n=new Notification(0,"Patient service is down",0,"fall back route enabled");

        notifys.add(n);

        return notifys;

    }

 

}