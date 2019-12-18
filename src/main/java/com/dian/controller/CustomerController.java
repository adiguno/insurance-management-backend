package com.dian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.dian.service.CustomerService;

@RestController
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerController() {
		this.customerService = null;
	}
}
