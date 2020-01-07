package com.dian.controller;

import com.dian.dto.LoginDto;
import com.dian.model.User;
import com.dian.service.UserService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import javax.validation.Valid;
import java.util.List;

/** 
 * NOTES
 * 		when new users sign up
 * 
 * 		new sign up method for every role
 * 			- signing up bm
 * 			- signing up agents
 * 			- signing up customers
 * 
 * @author guodi
 *
 */

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/signin")
    public String login(@RequestBody @Valid LoginDto loginDto) {
    	logger.debug("signing in: " + loginDto.getUsername());
    	logger.debug("password: " + loginDto.getPassword());
    	return userService.signin(loginDto.getUsername(), loginDto.getPassword()).orElseThrow(()->
               new HttpServerErrorException(HttpStatus.FORBIDDEN, "Login Failed"));
    }

    @PostMapping("/signup/bm")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public User signupBranchManager(@RequestBody @Valid LoginDto loginDto){
    	logger.debug("registering branch manager username: " + loginDto.getUsername());
    	logger.debug("registering branch manager password: " + loginDto.getPassword());    	
    	return userService.signupBranchManager(loginDto.getUsername(), loginDto.getPassword())
    			.orElseThrow(() -> new HttpServerErrorException(HttpStatus.BAD_REQUEST,"User already exists"));
    }
    @PostMapping("/signup/agent")
    @PreAuthorize("hasRole('ROLE_BM')")
    @ResponseStatus(HttpStatus.CREATED)
    public User signupAgent(@RequestBody @Valid LoginDto loginDto){
    	logger.debug("registering agent username: " + loginDto.getUsername());
    	logger.debug("registering agent password: " + loginDto.getPassword());    	
    	return userService.signupAgent(loginDto.getUsername(), loginDto.getPassword())
    			.orElseThrow(() -> new HttpServerErrorException(HttpStatus.BAD_REQUEST,"User already exists"));
    }
    @PostMapping("/signup/customer")
    @PreAuthorize("hasRole('ROLE_BM')")
    @ResponseStatus(HttpStatus.CREATED)
    public User signupCustomer(@RequestBody @Valid LoginDto loginDto){
    	logger.debug("registering customer username: " + loginDto.getUsername());
    	logger.debug("registering customer password: " + loginDto.getPassword());    	
    	return userService.signupCustomer(loginDto.getUsername(), loginDto.getPassword())
    			.orElseThrow(() -> new HttpServerErrorException(HttpStatus.BAD_REQUEST,"User already exists"));
    }
    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

}