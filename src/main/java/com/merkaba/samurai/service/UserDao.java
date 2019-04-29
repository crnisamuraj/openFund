package com.merkaba.samurai.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.merkaba.samurai.model.UserModel;
import com.merkaba.samurai.resource.UserResource;
import com.merkaba.samurai.util.exception.UserNotFoundException;

@Repository
@Transactional
public class UserDao {
	
	@Autowired
	UserRepository userRepository;
	
		
	public List<UserModel> findAll() {
		return userRepository.findAll();
	}
	
	public UserResource add(UserModel user) {
		UserModel retVal = userRepository.save(user);
		UserResource resource = new UserResource(retVal);
		return resource;
	}
	
	public UserResource find(Integer id) {
		Optional<UserModel> retVal = userRepository.findById(id);
		if (retVal.isPresent()) {
			UserResource resource = new UserResource(retVal.get());
			return resource;
		} else throw new UserNotFoundException("User with id: " + id + "not found");
	}
	
	public String remove (Integer id) {
		try {
			userRepository.deleteById(id);
			} catch (Exception e) {
				throw new UserNotFoundException("id: " + id + "not found");
			}
		return "User with id: " + id + "deleted." ;
	}
	
	public UserModel update (Integer id, UserModel userUpdate) {
		UserModel userU = userUpdate;
		userU.setId(id);
		return userRepository.save(userU);
	}

}
