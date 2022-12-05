package com.cognizant.xxStaffLeaveDetails.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staff_leave_details")
public class StaffLeaveDetails {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "clinic_id", nullable = false)
	private int clinicId;
	
	@Column(name = "staff_name", nullable = false)
	private String staffName;
	
	@Column(name = "specialty", nullable = false)
	private String specialty;
	
	@Column(columnDefinition = "DATE", name = "leaveDate", nullable = false)
	private LocalDate leaveDate;

	public StaffLeaveDetails() {
		super();
	}

	public StaffLeaveDetails(int clinicId, String staffName, String specialty, LocalDate leaveDate) {
		super();
		this.clinicId = clinicId;
		this.staffName = staffName;
		this.specialty = specialty;
		this.leaveDate = leaveDate;
	}

	public StaffLeaveDetails(int id, int clinicId, String staffName, String specialty, LocalDate leaveDate) {
		super();
		this.id = id;
		this.clinicId = clinicId;
		this.staffName = staffName;
		this.specialty = specialty;
		this.leaveDate = leaveDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClinicId() {
		return clinicId;
	}

	public void setClinicId(int clinicId) {
		this.clinicId = clinicId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public LocalDate getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(LocalDate leaveDate) {
		this.leaveDate = leaveDate;
	}
	
	

}
