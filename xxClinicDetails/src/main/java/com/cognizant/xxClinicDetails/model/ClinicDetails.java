package com.cognizant.xxClinicDetails.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clinic_details")
public class ClinicDetails {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "clinic_name", nullable = false)
	private String clinicName;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "state", nullable = false)
	private String state;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "contact_number", nullable = false, unique = true)
	private String contactNumber;
	
	@Column(name = "email_id", nullable = false, unique = true)
	private String emailId;

	public ClinicDetails() {
		super();
	}

	public ClinicDetails(String clinicName, String address, String city, String state, String country,
			String contactNumber, String emailId) {
		super();
		this.clinicName = clinicName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
	}

	public ClinicDetails(int id, String clinicName, String address, String city, String state, String country,
			String contactNumber, String emailId) {
		super();
		this.id = id;
		this.clinicName = clinicName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	

}
