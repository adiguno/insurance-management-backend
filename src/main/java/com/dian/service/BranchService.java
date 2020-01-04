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

	@Autowired
	public BranchService(BranchRepository branchRepository) {
		this.branchRepository = branchRepository;
	}
	
	public Branch updateBranch(Branch branch) {
		return this.branchRepository.save(branch);
	}
	
	public void deleteBranch(long id) {
		this.branchRepository.deleteById(id);
	}
	
	public Branch addBranch(Branch branch) {
		return this.branchRepository.save(branch);
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
