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
// create customer
// read:
//		all customers
//		customer by id
//		customer by last name
//		customer by branch id
// update
// delete

@Service
public class BranchService {
	
	public final BranchRepository branchRepository;

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
	
	public Optional<Branch> getBranchById(long id) {
		return this.branchRepository.findById(id);
	}
	
}
