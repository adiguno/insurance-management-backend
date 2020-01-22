package com.dian.model;

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
/**
 * NOTES:
 * 		no constructor using fields
 * 		no toString()
 * @author guodi
 *
 */

@Entity
@Table(name="CUSTOMER_POLICY_REGISTRATION")
public class CustomerPolicyRegistration {
	@Id
	@Column(name="CUSTOMER_POLICY_REGISTRATION_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	// customer
	@ManyToOne(fetch = FetchType.LAZY) // , optional = false
	@JoinColumn(name = "CUSTOMER_ID", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Customer customer; // foreign key
	
	// policy
	@ManyToOne(fetch = FetchType.LAZY) // , optional = false
	@JoinColumn(name = "POLICY_ID", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Policy policy; // foreign key
	
	// agent
	@ManyToOne(fetch = FetchType.LAZY) // , optional = false
	@JoinColumn(name = "AGENT_ID", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Agent agent; // foreign key
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Column(name="DATE")
	private LocalDate date;
	
	@Column(name="PREMIUM_TYPE")
	private String premiumType;
	
	@Column(name="NOMINEE_NAME")
	private String nomineeName;
	
	@Column(name="NOMINEE_RELATIONSHIP")
	private String nomineeRelationship;
	
	@Column(name="AGENT_COMMISSION")
	private double agentCommission;
	
	@Column(name="TERMS_AND_CONDITIONS")
	private boolean termsAndConditions;
	
	public CustomerPolicyRegistration() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getPremiumType() {
		return premiumType;
	}

	public void setPremiumType(String premiumType) {
		this.premiumType = premiumType;
	}

	public String getNomineeName() {
		return nomineeName;
	}

	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}

	public String getNomineeRelationship() {
		return nomineeRelationship;
	}

	public void setNomineeRelationship(String nomineeRelationship) {
		this.nomineeRelationship = nomineeRelationship;
	}

	public double getAgentCommission() {
		return agentCommission;
	}

	public void setAgentCommission(double agentCommission) {
		this.agentCommission = agentCommission;
	}

	public boolean isTermsAndConditions() {
		return termsAndConditions;
	}

	public void setTermsAndConditions(boolean termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}
	
	
	
}
