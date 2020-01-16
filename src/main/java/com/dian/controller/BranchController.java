package com.dian.controller;
import java.sql.Date;
import java.time.LocalDate;
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
import org.springframework.security.access.prepost.PreAuthorize;

import com.dian.model.Branch;
import com.dian.service.BranchService;



/**
 * Branch API
 * @author Adiguno
 * 
 * NOTES:
 *	- using request body
 *	- using Local Date
 *  - only CEO/Admin can edit
 *
 *  
 */

@RestController
@CrossOrigin(origins="http://localhost:4200", maxAge = 3600) // max age = 30 min
@RequestMapping("/api/branch")
public class BranchController {
	
	private BranchService branchService;
	
    private static final Logger logger = LogManager.getLogger(BranchController.class);

	
	@Autowired
	public BranchController(BranchService branchService) {
		this.branchService = branchService;
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Branch addNew(@RequestBody Branch branch) {
		return this.branchService.addBranch(branch);
	}	
	
	@PutMapping("/edit")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Branch editById(@RequestParam(value="id") long id, @RequestBody Branch branch) {
		logger.debug("update branch, id = " + id);
		Branch existing = this.branchService.getBranchById(id);
		existing.setBranchName(branch.getBranchName());
		existing.setAddress(branch.getAddress());
		existing.setCity(branch.getCity());
		existing.setState(branch.getState());
		existing.setDate(branch.getDate());
		existing.setPhone(branch.getPhone());
		return this.branchService.updateBranch(existing);
	}
	
    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteById(@RequestParam(value="id") long id) {
		logger.debug("delete branch, id = " + id);
		this.branchService.deleteBranch(id);
	}
	
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/all") 
	public List<Branch> findAll() {
		return branchService.getAllBranchs();
	}
	
	@GetMapping("/state")
	public List<Branch> findByState(@RequestParam(value="state") String state) {
		logger.debug("get branch, by state = " + state);
		return this.branchService.getBranchsByState(state);
		
	}
	
	@GetMapping("/id")
	public Branch findById(@RequestParam(value="id") long id) {
		logger.debug("get branch, by id = " + id);
		return this.branchService.getBranchById(id);
	}
}
