package com.auth.entity;

public  class PatientInfoRequest {
    private String jwtToken;
    private String patientId;
	public PatientInfoRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}


}
