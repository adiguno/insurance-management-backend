package com.dian.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dian.model.Branch;
import com.dian.repository.BranchRepository;

// used mainly for testing purposes
// dependency injection using constructor
//
// CRUD
// create branch
// read:
//		all branches
//		branch by id
//		branch by last name
//		branch by branch id
//			exception if id is not found
// update
// delete by id

@Service
public class BranchService {
	
	private final BranchRepository branchRepository;
    private static final Logger logger = LogManager.getLogger(BranchService.class);

	@Autowired
	public BranchService(BranchRepository branchRepository) {
		this.branchRepository = branchRepository;
	}
	
	// add branch
	public Branch addBranch(Branch branch) {
		return this.branchRepository.save(branch);
	}
	
	// update branch
	public Branch updateBranch(Branch branch) {
		if (!this.branchRepository.findById(branch.getBranchId()).isPresent()) {
			logger.debug("creating new branch inside update method");
		}
		return this.branchRepository.save(branch);
	}
	
	// delete branch
	public void deleteBranch(long id) {
		this.branchRepository.deleteById(id);
	}

	public List<Branch> getAllBranchs() {
		return (List<Branch>)this.branchRepository.findAll();
	}
	
	public List<Branch> getBranchsByState(String state) {
		List<Branch> list = new ArrayList<>();
		Iterable<Branch> itr = this.branchRepository.findByState(state);
		itr.forEach(list::add);
		return list;
	}
	
	public Branch getBranchById(long id) {
		return this.branchRepository.findById(id).get();
	}
	
}
