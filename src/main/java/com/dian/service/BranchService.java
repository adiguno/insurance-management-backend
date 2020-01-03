package com.dian.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dian.model.Branch;
import com.dian.repository.BranchRepository;

// used mainly for testing purposes
// dependency injection using constructor

// CRUD
// create branch
// read:
//		all branches
//		branch by id
//		branch by last name
//		branch by branch id
//			returns new empty branch if id is not found
// update
// delete

@Service
public class BranchService {
	
	private final BranchRepository branchRepository;

	@Autowired
	public BranchService(BranchRepository branchRepository) {
		this.branchRepository = branchRepository;
	}
	
	public Branch addBranch(Branch branch) {
		this.branchRepository.save(branch);
		return branch;
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
		return this.branchRepository.findById(id).orElse(new Branch());
	}
	
}
