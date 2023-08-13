package com.virtusa.healthcareproviderservice.entities;

import java.math.BigInteger;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
public class HealthCareProvider {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String providerName;
private String providerAddress;
private BigInteger providerContact;
private String providerEmail;
private Date availableDate;
private String availableStatus;
private int healthCareProviderId;
@Override
public String toString() {
	return "HealthCareProvider [id=" + id + ", providerName=" + providerName + ", providerAddress=" + providerAddress
			+ ", providerContact=" + providerContact + ", providerEmail=" + providerEmail + ", availableDate="
			+ availableDate + ", availableStatus=" + availableStatus + ", healthCareProviderId=" + healthCareProviderId
			+ "]";
}


}
