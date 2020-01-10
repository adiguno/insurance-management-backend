package com.dian.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.dian.model.Policy;
import com.dian.repository.PolicyRepository;

// used mainly for testing purposes
// dependency injection using constructor
//
// CRUD
// create policy
// read:
//		all policys
//		policy by policy name
//		policy by policy id
//			exception if id is not found
// update
// delete by id

@Service
public class PolicyService {
	
	private final PolicyRepository policyRepository;
    private static final Logger logger = LogManager.getLogger(PolicyService.class);

	@Autowired
	public PolicyService(PolicyRepository policyRepository) {
		this.policyRepository = policyRepository;
	}
	
	// add policy
	public Policy addPolicy(Policy policy) {
		return this.policyRepository.save(policy);
	}
	
	// update policy
	public Policy updatePolicy(Policy policy) {
		if (!this.policyRepository.findById(policy.getPolicyId()).isPresent()) {
			logger.debug("creating new policy inside update method");
		}
		return this.policyRepository.save(policy);
	}
	
	// delete policy
	public void deletePolicy(long id) {
		this.policyRepository.deleteById(id);
	}

	// get all policys
	public List<Policy> getAllPolicys() {
		return (List<Policy>)this.policyRepository.findAll();
	}
	
	// get policy by name
	public Policy getPolicyByName(String policyName) {
		Optional<Policy> policy = this.policyRepository.findByPolicyName(policyName);
//		return policy.orElseThrow(() ->
//        new UsernameNotFoundException(String.format("Policy with name %s does not exist", policyName)));
		return policy.get();
	}
	
	// get policy by id
	public Policy getPolicyById(long id) {
//		return this.policyRepository.findById(id).orElseThrow(() ->
//        new UsernameNotFoundException(String.format("Policy with id %s does not exist", id)));
		return this.policyRepository.findById(id).get();
	}
	
}
