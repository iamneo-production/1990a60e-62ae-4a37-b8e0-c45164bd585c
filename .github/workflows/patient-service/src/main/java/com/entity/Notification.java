package com.hackathon.entity;

public class Notification {

    private int notificationId;

 

    private String Medication;

 

    private int patientId;

 

    private String message ;

 

    public Notification() {
        super();
    }
    public Notification(int notificationId, String medication, int patientId, String message) {
        this.notificationId = notificationId;
        Medication = medication;
        this.patientId = patientId;
        this.message = message;
    }

 

    public int getNotificationId() {
        return notificationId;
    }

 

    public String getMedication() {
        return Medication;
    }

 

    public int getPatientId() {
        return patientId;
    }

 

    public String getMessage() {
        return message;
    }

 

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

 

    public void setMedication(String medication) {
        Medication = medication;
    }

 

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

 

    public void setMessage(String message) {
        this.message = message;
    }

}