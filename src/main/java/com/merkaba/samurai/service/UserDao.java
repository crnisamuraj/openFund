package com.merkaba.samurai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.merkaba.samurai.model.UserModel;
import com.merkaba.samurai.resource.UserResource;
import com.merkaba.samurai.util.exception.CustomException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDao {
	
	@Autowired
	UserRepository userRepository;
	
		
	public List<UserResource> findAll() {
		List<UserModel> users = userRepository.findAll();
		if (users.isEmpty()) {
			throw new CustomException("No users found", HttpStatus.NOT_FOUND);
		}
		List<UserResource> resources = new ArrayList<UserResource>();
		for(UserModel user:users) {
			UserResource resource = new UserResource(user);
			resources.add(resource);
		}
		return resources;
	}
	
	public UserResource add(UserModel user) {
		UserModel retVal = new UserModel();
		try {
			retVal = userRepository.save(user);
		} catch (Exception e) {
			throw new CustomException("Something went wrong with adding user, check all fields and try again", HttpStatus.BAD_REQUEST);
		}
		UserResource resource = new UserResource(retVal);
		return resource;
	}
	
	public UserResource find(Integer id) {
		Optional<UserModel> retVal = userRepository.findById(id);
		if (retVal.isPresent()) {
			UserResource resource = new UserResource(retVal.get());
			return resource;
		} else throw new CustomException("User with id: " + id + "not found", HttpStatus.NOT_FOUND);
	}
	
	public String remove (Integer id) {
		try {
			userRepository.deleteById(id);
			} catch (Exception e) {
				throw new CustomException("id: " + id + "not found", HttpStatus.NOT_FOUND);
			}
		return "User with id: " + id + "deleted." ;
	}
	
	public UserResource update (Integer id, UserModel userUpdate) {
		UserModel userU = userUpdate;
		userU.setId(id);
		UserResource resource = new UserResource(userRepository.save(userU));
		return resource;
	}

}
