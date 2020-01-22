package com.dian.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dian.model.Agent;
import com.dian.model.Branch;
import com.dian.model.Customer;
import com.dian.model.CustomerPolicyRegistration;
import com.dian.model.Policy;
import com.dian.service.AgentService;
import com.dian.service.BranchService;
import com.dian.service.CustomerPolicyRegistrationService;
import com.dian.service.CustomerService;
import com.dian.service.PolicyService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/customerPolicyRegistration")
public class CustomerPolicyRegistrationController {
	
	private CustomerPolicyRegistrationService cprService;
	
	private AgentService agentService;
	private CustomerService customerService;
	private PolicyService policyService;

    private static final Logger logger = LogManager.getLogger(CustomerPolicyRegistrationController.class);
    
	@Autowired
	public CustomerPolicyRegistrationController(
			CustomerPolicyRegistrationService cprService,
				AgentService agentService, 
				CustomerService customerService, 
				PolicyService policyService) {
		this.cprService = cprService;
		this.agentService = agentService;
		this.customerService = customerService;
		this.policyService = policyService;
	}

	@DeleteMapping("/delete")
	public void deleteById(@RequestParam(value="id") long id) {
		logger.debug("delete customer policy reg, id = " + id);
		this.cprService.deleteRegistration(id);
	}
	
	@PutMapping("/edit")
	public CustomerPolicyRegistration editById(
			@RequestParam(value="id") long id,
			@RequestParam(value="agentId") long agentId,
			@RequestParam(value="customerId") long customerId,
			@RequestParam(value="policyId") long policyId,
			@RequestBody CustomerPolicyRegistration cpr) {
		logger.debug("update customer policy reg, id = " + id);
		
		Agent agent = this.agentService.getAgentById(agentId);
		Policy policy = this.policyService.getPolicyById(policyId);
		Customer customer = this.customerService.getCustomerById(customerId);
		
		CustomerPolicyRegistration existing =  this.cprService.getRegistrationById(id);

		existing.setDate(cpr.getDate());
		existing.setAgent(agent);
		existing.setCustomer(customer);
		existing.setPolicy(policy);
		existing.setNomineeName(cpr.getNomineeName());
		existing.setNomineeRelationship(cpr.getNomineeRelationship());
		existing.setPremiumType(cpr.getPremiumType());
		existing.setTermsAndConditions(cpr.isTermsAndConditions());
		return this.cprService.updateRegistration(existing);
	}

	// add
	@PostMapping("/add")
	public CustomerPolicyRegistration addNew(
			@RequestBody CustomerPolicyRegistration cpr, 
			@RequestParam(value="customerId") long customerId,
			@RequestParam(value="agentId") long agentId,
			@RequestParam(value="policyId") long policyId) {
		logger.debug("add customer policy reg, cus = " + customerId + ", policy = "+policyId+", agent = "+agentId);
		Customer customer =  this.customerService.getCustomerById(customerId);
		Agent agent = this.agentService.getAgentById(agentId);
		Policy policy = this.policyService.getPolicyById(policyId);
		
		cpr.setCustomer(customer);
		cpr.setAgent(agent);
		cpr.setPolicy(policy);
		return this.cprService.addRegistration(cpr);
	}	
	
	@GetMapping("/all") 
	public List<CustomerPolicyRegistration> findAll() {
		return this.cprService.getAllRegistrations();
	}
	
	@GetMapping("/agent")
	public List<CustomerPolicyRegistration> findByAgent(@RequestParam(value="agent") Agent agent) {
		logger.debug("get customer policy reg, by agent = " + agent.getId());
		return this.cprService.getRegistrationsByAgent(agent);
	}
	
	@GetMapping("/id")
	public CustomerPolicyRegistration findById(@RequestParam(value="id") long id) {
		logger.debug("get customer policy reg, by id = " + id);
		return this.cprService.getRegistrationById(id);
	}
	
}
