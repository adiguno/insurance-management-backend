package com.dian.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dian.model.Agent;
import com.dian.model.CustomerPolicyRegistration;
import com.dian.repository.AgentRepository;
import com.dian.repository.CustomerPolicyRegistrationRepository;

@Service
public class CustomerPolicyRegistrationService {
	private final CustomerPolicyRegistrationRepository cprRepo;
	
	@Autowired
	public CustomerPolicyRegistrationService(CustomerPolicyRegistrationRepository repo) {
		this.cprRepo = repo;
	}
	// get all
	public List<CustomerPolicyRegistration> getAllRegistrations() {
		return (List<CustomerPolicyRegistration>)this.cprRepo.findAll();
	}
	// get with id
	public CustomerPolicyRegistration getRegistrationById(long id) {
		return this.cprRepo.findById(id).get();
	}	
	// get with Agent
	public List<CustomerPolicyRegistration> getRegistrationsByAgent(Agent agent) {
		return (List<CustomerPolicyRegistration>) this.cprRepo.findByAgent(agent);
	}
	
	// add
	public CustomerPolicyRegistration addRegistration(CustomerPolicyRegistration reg) {
		return this.cprRepo.save(reg);
	}
	// update 	
	public CustomerPolicyRegistration updateRegistration(CustomerPolicyRegistration reg) {
		return this.cprRepo.save(reg);
	}
	// delete
	public void deleteRegistration(long id) {
		this.cprRepo.deleteById(id);
	}
}
