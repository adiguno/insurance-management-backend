package com.dian.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/*
 * NOTES:
 * 	- policyType is a string
 */

@Entity
@Table(name="POLICY")
public class Policy {
	@Id
	@Column(name="POLICY_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long policyId;
	
	@Column(name="POLICY_NAME")
	private String policyName;
	
	@Column(name="POLICY_TERM")
	private int policyTerm;
	
	@Column(name="POLICY_AMOUNT")
	private double policyAmount;
	
	@Column(name="POLICY_INTEREST")
	private double policyInterest;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name="DATE")
	private LocalDate date;
	
	@Column(name="POLICY_TYPE")
	private String policyType;
	
	@Column(name="MATURITY_AMOUNT")
	private double maturityAmount;
	

	public Policy() {}


	public Policy(String policyName, int policyTerm, double policyAmount, double policyInterest, LocalDate date,
			String policyType, double maturityAmount) {
		super();
		this.policyName = policyName;
		this.policyTerm = policyTerm;
		this.policyAmount = policyAmount;
		this.policyInterest = policyInterest;
		this.date = date;
		this.policyType = policyType;
		this.maturityAmount = maturityAmount;
	}


	public long getPolicyId() {
		return policyId;
	}


	public void setPolicyId(long policyId) {
		this.policyId = policyId;
	}


	public String getPolicyName() {
		return policyName;
	}


	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}


	public int getPolicyTerm() {
		return policyTerm;
	}


	public void setPolicyTerm(int policyTerm) {
		this.policyTerm = policyTerm;
	}


	public double getPolicyAmount() {
		return policyAmount;
	}


	public void setPolicyAmount(double policyAmount) {
		this.policyAmount = policyAmount;
	}


	public double getPolicyInterest() {
		return policyInterest;
	}


	public void setPolicyInterest(double policyInterest) {
		this.policyInterest = policyInterest;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public String getPolicyType() {
		return policyType;
	}


	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}


	public double getMaturityAmount() {
		return maturityAmount;
	}


	public void setMaturityAmount(double maturityAmount) {
		this.maturityAmount = maturityAmount;
	}


	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyName=" + policyName + ", policyTerm=" + policyTerm
				+ ", policyAmount=" + policyAmount + ", policyInterest=" + policyInterest + ", date=" + date
				+ ", policyType=" + policyType + ", maturityAmount=" + maturityAmount + "]";
	}
	
	
}
