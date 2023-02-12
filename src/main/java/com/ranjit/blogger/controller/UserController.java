package com.ranjit.blogger.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranjit.blogger.dto.ApiResponse;
import com.ranjit.blogger.dto.Users;
import com.ranjit.blogger.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@Value("${server.port}")
	public String port;

	@GetMapping("/getPort")
	public void getPort() {
		System.out.println("Port :" + port);
	}

	@GetMapping("/getUserById/{id}")
	public ResponseEntity<Users> getUserByUserId(@PathVariable("id") String id) {
		Users users = userService.getUserById(Integer.parseInt(id));
		return new ResponseEntity<Users>(users, HttpStatus.OK);
	}

	@GetMapping("/getAllUser")
	public ResponseEntity<List<Users>> getAllUser() {
		List<Users> lsitOfUsers = userService.getAllUsers();
		return new ResponseEntity<List<Users>>(lsitOfUsers, HttpStatus.OK);

	}

	@PostMapping("/saveUser")
	public ResponseEntity<ApiResponse> saveUser(@Valid @RequestBody Users user) {
		Users users = userService.saveUser(user);
		return new ResponseEntity<>(new ApiResponse("User created successfully", true), HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteUserById/{id}")
	public ResponseEntity<ApiResponse> deleteUserById(@PathVariable("id") Integer id) {
		this.userService.deleteUserById(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User delete Successfully", true), HttpStatus.OK);
	}

	@PutMapping("/updateUserById")
	public ResponseEntity<Users> updateUserById(@Valid @RequestBody Users user) {
		user = userService.updateUser(user,user.getUserid());
		return new ResponseEntity<Users>(user,HttpStatus.OK);
	}
}
