package com.hackathon.feign;

 

import org.springframework.cloud.openfeign.FeignClient;

 

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import com.hackathon.entity.Notification;

 

@FeignClient(name = "NOTIFICATION-SERVICE")
public interface NotificationFeignClient {


    @GetMapping("/notifications/{patientId}")
    public List<Notification> notifications(@PathVariable("patientId") int pid);

}
