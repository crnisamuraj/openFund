package com.merkaba.samurai.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.merkaba.samurai.model.UserModel;
import com.merkaba.samurai.resource.UserResource;
import com.merkaba.samurai.service.UserDao;
import com.merkaba.samurai.util.exception.UserNotFoundException;

@RestController
@RequestMapping("/user")
public class UserCtl {
	
	@Autowired
	private UserDao userService;
	

	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<?> getAllUsers() {		
		List<UserResource> users = userService.findAll();
		if (users.isEmpty())
			throw new UserNotFoundException("No users found");
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET, path="/{user_id}", produces="application/json")
	public ResponseEntity<?> getUser(@PathVariable Integer user_id) {
		UserResource resource = userService.find(user_id);
		return new ResponseEntity<>(resource, HttpStatus.OK);
	}	

	
	@RequestMapping(method=RequestMethod.DELETE, path="/{user_id}", produces="application/json")
	public ResponseEntity<?> removeUser(@PathVariable Integer user_id) {
		String retVal = userService.remove(user_id);
		return ResponseEntity.ok(retVal);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<?> addUser(@Valid @RequestBody UserModel user) {
		UserResource resource = userService.add(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(resource.getId()).toUri();
		return ResponseEntity.created(location).body(resource);
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="/{user_id}", produces="application/json")
	public ResponseEntity<?> updateUser(@PathVariable Integer user_id, UserModel user) {
		UserResource resource = userService.update(user_id, user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(location).body(resource);
	}
	

}