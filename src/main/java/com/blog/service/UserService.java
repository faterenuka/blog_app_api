package com.blog.service;

import java.util.List;

import com.blog.payloads.UserDTO;

public interface UserService {

	UserDTO registerNewUser(UserDTO userDto);
	
	UserDTO createUser(UserDTO userDto);
	
	UserDTO updateUser(UserDTO userDto,Integer userId);
	
	UserDTO getUserById(Integer userId);
	
	List<UserDTO>getAllUsers();
	
	void deleteUser(Integer userId);
	
}
