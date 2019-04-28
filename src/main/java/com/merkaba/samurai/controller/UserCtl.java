package com.merkaba.samurai.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.merkaba.samurai.model.UserModel;
import com.merkaba.samurai.service.UserDao;
import com.merkaba.samurai.util.exception.UserNotFoundException;

@RestController
@RequestMapping("/user")
public class UserCtl {
	
	@Autowired
	private UserDao userService;
	

	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<?> getAllUsers() {
		List<UserModel> users = userService.findAll();
		return ResponseEntity.ok(users);
	}

	@RequestMapping(method=RequestMethod.GET, path="/{user_id}", produces="application/json")
	public ResponseEntity<?> getUser(@PathVariable Integer user_id) {
		UserModel user = userService.find(user_id);
		if(user == null)
			throw new UserNotFoundException("id: " + user_id);
		return ResponseEntity.ok(user);
	}	

	
	@RequestMapping(method=RequestMethod.DELETE, path="/{user_id}", produces="application/json")
	public ResponseEntity<?> removeUser(@PathVariable Integer user_id) {
		UserModel user = userService.remove(user_id);
		if (user == null)
			throw new UserNotFoundException("id: " + user_id);
		return ResponseEntity.ok(user);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<?> addUser(@RequestBody UserModel user) {
		UserModel savedUser = userService.add(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="/{user_id}", produces="application/json")
	public ResponseEntity<?> updateUser(@PathVariable Integer user_id, UserModel user) {
		user = userService.update(user_id, user);
		return ResponseEntity.ok(user);
	}
	

}