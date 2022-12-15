package com.crud.eample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.crud.eample.entity.User;
import com.crud.eample.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	
	//User Creation Operations
	@PostMapping("/saveUsers")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User saveUser=userService.saveUser(user);
		return new ResponseEntity<>(saveUser,HttpStatus.CREATED);
	}
	
	
	//All get Operations
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsersFromDb() {
		List<User> allUsers=userService.getAllUsers();
		return new ResponseEntity<>(allUsers,HttpStatus.OK);
	}
	
	//Update Operation
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable int id) {
		User updateUs=userService.updateUserInDb(user,id);
		return new ResponseEntity<>(updateUs,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUserInDB(id);
	}
	
}
