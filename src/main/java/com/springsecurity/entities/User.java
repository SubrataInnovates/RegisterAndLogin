package com.springsecurity.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "Name is mandatory")
	@Size(min = 3,max = 20,message = "Name must be between 3 to 20 characters")
	private String name;
	
	@NotBlank(message = "Username is mandatory")
	@Size(min = 5,max = 20,message = "Username must be between 3 to 20 characters")
	@Column(unique = true)
	private String username;
	
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email should be valid")
	@Column(unique = true)
	private String email;
	
	@NotBlank(message = "Password is mandatory")
	@Size(min = 5,max = 10,message = "Password must be between 3 to 20 characters")
	private String password;
	//private String role;
	
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
//	private List<Contacts> contacts=new ArrayList<>();

}
