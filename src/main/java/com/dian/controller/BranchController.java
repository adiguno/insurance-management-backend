package com.dian.controller;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dian.model.Branch;
import com.dian.service.BranchService;



/**
 * Branch API
 * @author Adiguno
 * 
 * NOTES:
 *	- using request body
 *	- using Local Date
 * 
 * 
 * Questions:
 * 	- why do we need address and location
 *  - what is the unique identifier (other than id), email and password? or username and password?
 *
 * TODO: 
 *  -[x] fix date parameter
 *  -[x] add branch using request body
 *  -[x] retrieve all of the branches
 *  -[x] retrieve the list of branches with state
 *  	- using request param
 *  -[x] retrieve the list of branches with id
 *  
 *  -[ ] update
 *  -[ ] delete
 *  
 */

@RestController
@RequestMapping("/api/branch")
public class BranchController {
	
	private BranchService branchService;
	
	@Autowired
	public BranchController(BranchService branchService) {
		this.branchService = branchService;
	}
	

	@PostMapping("/add")
	public Branch addNew(@RequestBody Branch branch) {
		return this.branchService.addBranch(branch);
	}	
	@GetMapping("/all") 
	public List<Branch> findAll() {
		return branchService.getAllBranchs();
	}
	
	@GetMapping("/state")
	public List<Branch> findByState(@RequestParam(value="state") String state) {
		return this.branchService.getBranchsByState(state);
		
	}
	
	@GetMapping("/id")
	public Branch findById(@RequestParam(value="id") long id) {
		return this.branchService.getBranchById(id);
	}
}
