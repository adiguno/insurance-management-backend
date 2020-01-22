package com.dian.controller;


import java.sql.Date;
import java.util.List;
import java.util.Optional;


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

import com.dian.model.Branch;
import com.dian.model.Agent;
import com.dian.service.BranchService;
import com.dian.service.AgentService;



/**
 * 
 * @author Adiguno
 * 
 * NOTES:
 *	- using request params (should be used for searching/filtering)
 *	- use username as the unique check
 * 
 * - missing AUTHORIZATION
 * 
 * 
 * Questions:
 * 	- why do we need passwords
 * 		- no need for storing passwords in the customer table
 *  - what is the unique identifier (other than id), email and password? or username and password?
 *  	- using username as unique id
 *  
 *
 */

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/agent")
public class AgentController {
	
	private AgentService agentService;
	private BranchService branchService;
	
    private static final Logger logger = LogManager.getLogger(AgentController.class);

	
	@Autowired
	public AgentController(AgentService agentService, BranchService branchService) {
		this.agentService = agentService;
		this.branchService = branchService;
		
	}
	
	@DeleteMapping("/delete")
	public void deleteById(@RequestParam(value="id") long id) {
		logger.debug("delete agent, id = " + id);
		this.agentService.deleteAgent(id);
	}
	
	@PutMapping("/edit")
	public Agent editById(
			@RequestParam(value="id") long id,
			@RequestParam(value="branchId") long branchId,
			@RequestBody Agent cus) {
		logger.debug("update agent, id = " + id);
		Branch branch = this.branchService.getBranchById(branchId);
		Agent existing =  this.agentService.getAgentById(id);
		existing.setFirstName(cus.getFirstName());
		existing.setLastName(cus.getLastName());
		existing.setDate(cus.getDate());
		existing.setBranch(branch);
		existing.setUsername(cus.getUsername());
		existing.setPassword(cus.getPassword());
		return this.agentService.updateAgent(existing);
	}

	@PostMapping("/add")
	public Agent addNew(@RequestBody Agent man, @RequestParam(value="branchId") long branchId) {
		logger.debug("add agent, branchId = " + branchId);
		Branch branch =  this.branchService.getBranchById(branchId);
		man.setBranch(branch);
		return this.agentService.addAgent(man);
	}	
	
	@GetMapping("/all") 
	public List<Agent> findAll() {
		return this.agentService.getAllAgents();
	}
	
	@GetMapping("/username")
	public Agent findByUsername(@RequestParam(value="username") String username) {
		logger.debug("get agent, by username = " + username);
		return this.agentService.getAgentByUsername(username);
	}
	
	@GetMapping("/id")
	public Agent findById(@RequestParam(value="id") long id) {
		logger.debug("get agent, by id = " + id);
		return this.agentService.getAgentById(id);
	}
}
