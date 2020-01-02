package com.dian.model;

//import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * QUESTIONS:
 * 	- what's the difference between address and location
 *  - PHONE: string or number
 */

@Entity
@Table(name="BRANCH")
public class Branch {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BRANCH_ID")
	private long branchId;
	
	@Column(name="BRANCH_NAME")
	private String branchName;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="DATE")
	private LocalDate date;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	

	public Branch() {}
	public Branch(long branchId, String branchName, String address, String phone, String location, LocalDate date,
			String city, String state) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.address = address;
		this.phone = phone;
		this.location = location;
		this.date = date;
		this.city = city;
		this.state = state;
	}


	public long getBranchId() {
		return branchId;
	}

	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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
	
	
}
