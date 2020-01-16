package com.dian.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dian.model.Policy;
import com.dian.service.PolicyService;

/**
 * 
 * @author guodi
 *
 */

@RestController
@CrossOrigin(origins="http://localhost:4200", maxAge = 3600) // max age = 30 min
@RequestMapping("/api/policy")
public class PolicyController {
	
    private static final Logger logger = LogManager.getLogger(CustomerController.class);
	
	private PolicyService policyService;
	
	@Autowired
	public PolicyController (PolicyService ps) {
		this.policyService = ps;
	}
	
	// add new policy
	@PostMapping("add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Policy addNew(@RequestBody Policy policy) {
		return this.policyService.addPolicy(policy);
	}
	
	// get all policys
	@GetMapping("/all")
	public List<Policy> findAll() {
		return this.policyService.getAllPolicys();
	}
	
	// get policy by policy name
	@GetMapping("/policyname")
	public Policy findByPolicyName(@RequestParam(value="policyName") String policyName) {
		return this.policyService.getPolicyByName(policyName);
	}
	
	// get policy by id
	@GetMapping("/id")
	public Policy findByPolicyId(@RequestParam(value="id") long policyId) {
		return this.policyService.getPolicyById(policyId);
	}
	
	// update policy
	@PutMapping("/edit")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Policy editById(@RequestParam(value="id") long policyId, @RequestBody Policy policy) {
		logger.debug("update policy, id = " + policyId);
		Policy existing =  this.policyService.getPolicyById(policyId);
		existing.setPolicyName(policy.getPolicyName());
		existing.setPolicyTerm(policy.getPolicyTerm());
		existing.setPolicyAmount(policy.getPolicyAmount());
		existing.setPolicyInterest(policy.getPolicyInterest());
		existing.setDate(policy.getDate());
		existing.setPolicyType(policy.getPolicyType());
		existing.setMaturityAmount(policy.getMaturityAmount());
		return this.policyService.updatePolicy(existing);
	}
	
	// delete policy by id
	@DeleteMapping("/delete")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteById(@RequestParam(value="id") long policyId) {
		logger.debug("delete policy, id = " + policyId);
		this.policyService.deletePolicy(policyId);
	}
	
}
