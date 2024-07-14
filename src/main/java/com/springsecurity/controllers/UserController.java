package com.springsecurity.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.springsecurity.Exception.UserAlreadyExistsException;

import com.springsecurity.entities.User;
import com.springsecurity.repository.UserRepository;
import com.springsecurity.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserController 
{
	@Autowired
	private UserService service;
	private static final Logger logger=LoggerFactory.getLogger(UserController.class);
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user)
	{
		
			
		try 
		{
			User registerUser = service.registerUser(user);
			logger.info("User is registers : {} "+registerUser);
			return ResponseEntity.ok(registerUser);
		}
		catch (UserAlreadyExistsException e)
		{
			logger.info("Error in adding user : {} "+e.getStackTrace());
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
