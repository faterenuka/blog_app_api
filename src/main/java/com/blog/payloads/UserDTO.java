package com.blog.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.blog.entity.Role;

public class UserDTO {

	private int id;
	
	@NotEmpty
	@Size(min = 4,message="Name should have min 4 character")
	private String name;
	
	@Email(message = "Email address is not valid")
	@NotEmpty(message = "Email is required !!")
	private String email;
	
	@NotEmpty
	@Size(min = 3, max = 10,message="password should have min 3 character and max 10 character")
	private String password;
	
	@NotNull
	private String about;
	
	private Set<RoleDTO> roles = new HashSet<>();

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(int id, String name, String email, String password, String about) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleDTO> roles) {
		this.roles = roles;
	}
	
	
	
}
