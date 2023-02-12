package com.ranjit.blogger.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ranjit.blogger.dto.Users;
import com.ranjit.blogger.entity.UsersEntity;


public interface UserService {

	public Users saveUser(Users user);
	public Users createUser(Users user);
	public Users updateUser(Users user,Integer userId);
	public Users getUserById(Integer userId);
	public List<Users> getAllUsers();
	public void deleteUserById(Integer userId);
	
	
}
