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
import com.dian.model.Manager;
import com.dian.service.BranchService;
import com.dian.service.ManagerService;



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
@RequestMapping("/api/manager")
public class ManagerController {
	
	private ManagerService managerService;
	private BranchService branchService;
	
    private static final Logger logger = LogManager.getLogger(ManagerController.class);

	
	@Autowired
	public ManagerController(ManagerService managerService, BranchService branchService) {
		this.managerService = managerService;
		this.branchService = branchService;
		
	}
	
	@DeleteMapping("/delete")
	public void deleteById(@RequestParam(value="id") long id) {
		logger.debug("delete manager, id = " + id);
		this.managerService.deleteManager(id);
	}
	
	@PutMapping("/edit")
	public Manager editById(
			@RequestParam(value="id") long id,
			@RequestParam(value="branchId") long branchId,
			@RequestBody Manager cus) {
		logger.debug("update manager, id = " + id);
		Branch branch = this.branchService.getBranchById(branchId);
		Manager existing =  this.managerService.getManagerById(id);
		existing.setFirstName(cus.getFirstName());
		existing.setLastName(cus.getLastName());
		existing.setAge(cus.getAge());
		existing.setSex(cus.getSex());
		existing.setDate(cus.getDate());
		existing.setQualification(cus.getQualification());
		existing.setAddress(cus.getAddress());
		existing.setBranch(branch);
		existing.setUsername(cus.getUsername());
		existing.setPassword(cus.getPassword());
		return this.managerService.updateManager(existing);
	}

	@PostMapping("/add")
	public Manager addNew(@RequestBody Manager man, @RequestParam(value="branchId") long branchId) {
		logger.debug("add manager, branchId = " + branchId);
		Branch branch =  this.branchService.getBranchById(branchId);
		man.setBranch(branch);
		return this.managerService.addManager(man);
	}	
	
	@GetMapping("/all") 
	public List<Manager> findAll() {
		return this.managerService.getAllManagers();
	}
	
	@GetMapping("/username")
	public Manager findByUsername(@RequestParam(value="username") String username) {
		logger.debug("get manager, by username = " + username);
		return this.managerService.getManagerByUsername(username);
	}
	
	@GetMapping("/id")
	public Manager findById(@RequestParam(value="id") long id) {
		logger.debug("get manager, by id = " + id);
		return this.managerService.getManagerById(id);
	}
}
