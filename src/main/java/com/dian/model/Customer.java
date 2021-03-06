/**
 * 
 */
package com.dian.model;


//import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author guodi
 * 
 * NOTES:
 * 		- date is now using Local Date
 *		- BRANCH_ID foreign key, ManyToOne unidirectional implementation
 */

@Entity
@Table(name="CUSTOMER")
public class Customer {
	@Id
	@Column(name="CUSTOMER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="SEX")
	private String sex;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name="DATE")
	private LocalDate date; // sql date
	
	@Column(name="QUALIFICATION")
	private String qualification;
	
	@Column(name="OCCUPATION")
	private String occupation;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="EMAIL")
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "BRANCH_ID", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnore
	private Branch branch; // foreign key
	
	public Customer() {}
	public Customer(String firstName, String lastName, int age, String sex, LocalDate date, String qualification,
			String occupation, String address, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.sex = sex;
		this.date = date;
		this.qualification = qualification;
		this.occupation = occupation;
		this.address = address;
		this.email = email;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", sex="
				+ sex + ", date=" + date + ", qualification=" + qualification + ", occupation=" + occupation
				+ ", address=" + address + ", email=" + email + ", branch =" + branch.toString()
				+ "]";
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	
}
