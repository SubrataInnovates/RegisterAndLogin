package com.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>
{

	User findByUsername(String username);
	User findByEmail(String email);
}
