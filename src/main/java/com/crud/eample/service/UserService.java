package com.crud.eample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.eample.entity.User;
import com.crud.eample.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	public User saveUser(User user) {
		System.out.println("============Save User=================");
		User saveUser=userRepo.save(user);
		return saveUser;
		
	}

	public List<User> getAllUsers() {
		System.out.println("===========All Users From DB===============");
		List<User> allUsers=userRepo.findAll();
		return allUsers;
		
	}
	
	public User updateUserInDb(User user,int id) {
		System.out.println("===========Update user========");
		User exist_user=userRepo.findById(user.getId()).get();
		exist_user.setName(user.getName());
		exist_user.setCompany(user.getCompany());
		User saveUserData=userRepo.save(exist_user);
		return saveUserData;
	}
	
	public void deleteUserInDB(int id) {
		System.out.println("===========Delete user========");
		userRepo.deleteById(id);
	}	
}
