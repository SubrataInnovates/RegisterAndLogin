package com.springsecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springsecurity.Exception.UserAlreadyExistsException;
import com.springsecurity.entities.User;
import com.springsecurity.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository repository;
	

	@Override
	public User registerUser(User user)
	{
		if(repository.findByUsername(user.getUsername())!=null)
		{
			throw new UserAlreadyExistsException("Username is already taken !!");
		}
		
		if(repository.findByEmail(user.getPassword())!=null)
		{
			throw new UserAlreadyExistsException("Email is already registerd !!");
		}
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		return repository.save(user);
		
	}

}
