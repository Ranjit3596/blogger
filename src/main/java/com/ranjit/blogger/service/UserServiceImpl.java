package com.ranjit.blogger.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.ranjit.blogger.Exception.ResourceNotFoundException;
import com.ranjit.blogger.dto.Users;
import com.ranjit.blogger.entity.UsersEntity;
import com.ranjit.blogger.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	ModelMapper mapper;

	@Override
	public Users saveUser(Users user) {

		/*
		 * UsersEntity userEntity = new UsersEntity();
		 * userEntity.setName(user.getName());
		 * userEntity.setPassword(user.getPassword());
		 * userEntity.setEmail(user.getEmail()); userEntity.setAbout(user.getAbout());
		 * userRepo.save(userEntity);
		 */

		return this.createUser(user);
	}

	@Override
	public Users createUser(Users user) {
		UsersEntity userEntity = this.mapper.map(user, UsersEntity.class);
		userEntity = userRepo.save(userEntity);
		user = this.mapper.map(userEntity, Users.class);
		return user;
	}

	@Override
	public Users updateUser(Users user, Integer userId) {
		Users updateUser = new Users();
		UsersEntity userEntity = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		UsersEntity updateUsers = this.mapper.map(user, UsersEntity.class);
		updateUsers = userRepo.save(updateUsers);
		Users updatedUsers = this.mapper.map(updateUsers, Users.class);
		return updatedUsers;
	}

	@Override
	public Users getUserById(Integer userId) {
		UsersEntity userEntity = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		Users users = this.mapper.map(userEntity, Users.class);
		return  users;
	}

	@Override
	public List<Users> getAllUsers() {
		List<UsersEntity> list = userRepo.findAll();
		List<Users> listOfUser = list.stream().map(userEntity -> {
			Users user = new Users();
			user.setUserid(userEntity.getUserid());
			user.setEmail(userEntity.getEmail());
			user.setName(userEntity.getName());
			user.setAbout(userEntity.getAbout());
			return user;
		}).collect(Collectors.toList());
		return listOfUser;
	}

	@Override
	public void deleteUserById(Integer userId) {
		userRepo.deleteById(userId);
	}
}
