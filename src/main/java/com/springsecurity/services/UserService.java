package com.springsecurity.services;

import com.springsecurity.Exception.UserAlreadyExistsException;
import com.springsecurity.entities.User;

public interface UserService 
{
	User registerUser(User user)throws UserAlreadyExistsException;

}
