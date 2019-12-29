package com.dian.controller;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
 *	- using request params
 * 
 * 
 * Questions:
 * 	- why do we need address and location
 *  - what is the unique identifier (other than id), email and password? or username and password?
 *
 * TODO: 
 *  -[ ] fix date parameter
 *  	- options:
 *  		1. use today's date
 *  			- load in pre-existing records before startup (schema.sql ??)
 *  		2. pass in sql date in query param
 *  
 *  -[x] retrieve all of the branches
 *  -[x] retrieve the list of branches with state
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
	
	// TODO date
	@PostMapping("/add")
	public Branch addNew(@RequestParam(value="branchName") String branchName,
			@RequestParam(value="date", required=false) Date date,
			@RequestParam(value="phone") String phone,
			@RequestParam(value="address") String address,
			@RequestParam(value="location") String location,
			@RequestParam(value="city") String city,
			@RequestParam(value="state") String state) {
		Branch branch = new Branch();
		branch.setBranchName(branchName);
		branch.setDate(date);
		branch.setAddress(address);
		branch.setLocation(location);
		branch.setCity(city);
		branch.setState(state);
		
		this.branchService.addBranch(branch);
		return branch;
	}
	
	@GetMapping("/all") 
	public List<Branch> findAll() {
		return branchService.getAllBranchs();
	}
	
	@GetMapping("/state")
	public List<Branch> findByState(String state) {
		return this.branchService.getBranchsByState(state);
		
	}
	
	@GetMapping("/id")
	public Optional<Branch> findById(@RequestParam(value="id") long id) {
		return this.branchService.getBranchById(id);
	}
}
