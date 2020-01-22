package com.dian.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dian.model.Manager;
import com.dian.repository.ManagerRepository;

@Service
public class ManagerService {
	private final ManagerRepository managerRepo;
	
	@Autowired
	public ManagerService(ManagerRepository repo) {
		this.managerRepo = repo;
	}
	// get all
	public List<Manager> getAllManagers() {
		return (List<Manager>)this.managerRepo.findAll();
	}
	// get manager with user name
	public Manager getManagerByUsername(String username) {
		return this.managerRepo.findByUsername(username);
	}	
	// get with id
	public Manager getManagerById(long id) {
		return this.managerRepo.findById(id).get();
	}
	// add
	public Manager addManager(Manager man) {
		return this.managerRepo.save(man);
	}
	// update 	
	public Manager updateManager(Manager man) {
		return this.managerRepo.save(man);
	}
	// delete
	public void deleteManager(long id) {
		this.managerRepo.deleteById(id);
	}
}
