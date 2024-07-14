package com.springsecurity.Exception;

public class UserAlreadyExistsException  extends RuntimeException
{
	public UserAlreadyExistsException(String message)
	{
		super(message);
	}

}
