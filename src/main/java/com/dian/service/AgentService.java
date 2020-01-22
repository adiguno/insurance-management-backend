package com.dian.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dian.model.Agent;
import com.dian.repository.AgentRepository;

@Service
public class AgentService {
	private final AgentRepository agentRepo;
	
	@Autowired
	public AgentService(AgentRepository repo) {
		this.agentRepo = repo;
	}
	// get all
	public List<Agent> getAllAgents() {
		return (List<Agent>)this.agentRepo.findAll();
	}
	// get agent with user name
	public Agent getAgentByUsername(String username) {
		return this.agentRepo.findByUsername(username);
	}	
	// get with id
	public Agent getAgentById(long id) {
		return this.agentRepo.findById(id).get();
	}
	// add
	public Agent addAgent(Agent man) {
		return this.agentRepo.save(man);
	}
	// update 	
	public Agent updateAgent(Agent man) {
		return this.agentRepo.save(man);
	}
	// delete
	public void deleteAgent(long id) {
		this.agentRepo.deleteById(id);
	}
}
