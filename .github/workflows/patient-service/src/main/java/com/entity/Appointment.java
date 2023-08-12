package com.hackathon.entity;

public class Appointment {

    int appointmentId;
    int doctorId;
    private int patientId;
    private String medication;
    private String scheduleTime;

    public Appointment(){
        super();
    }



    public Appointment(int appointmentId, int doctorId, int patientId, String medication, String scheduleTime) {
        super();
        this.appointmentIdId = appointmentId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.medication = medication;
        this.scheduleTime = scheduleTime;
    }

 

    public int getAppointmentId() {
        return appointmentId;
    }

 

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

 

    public int getDoctorId() {
        return doctorId;
    }

 

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

 

    public int getPatientId() {
        return patientId;
    }

 

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

 

    public String getMedication() {
        return medication;
    }

 

    public void setMedication(String medication) {
        this.medication = medication;
    }

 

    public String getScheduleTime() {
        return scheduleTime;
    }

 

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }



 

}