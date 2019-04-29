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
		List<UserResource> resources = userService.findAll();
		if (resources.isEmpty())
			throw new UserNotFoundException("No users found");
		return new ResponseEntity<>(resources, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET, path="/{user_id}", produces="application/json")
	public ResponseEntity<?> getUser(@PathVariable Integer user_id) {
		UserModel user = userService.find(user_id);
		if(user == null)
			throw new UserNotFoundException("id: " + user_id);
		UserResource resource = new UserResource(user);
		return new ResponseEntity<>(resource, HttpStatus.OK);
	}	

	
	@RequestMapping(method=RequestMethod.DELETE, path="/{user_id}", produces="application/json")
	public ResponseEntity<?> removeUser(@PathVariable Integer user_id) {
		UserModel user = userService.remove(user_id);
		if (user == null)
			throw new UserNotFoundException("id: " + user_id);
		UserResource resource = new UserResource(user);
		return ResponseEntity.ok(resource);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<?> addUser(@Valid @RequestBody UserModel user) {
		UserModel savedUser = userService.add(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		UserResource resource = new UserResource(user);
		return ResponseEntity.created(location).body(resource);
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="/{user_id}", produces="application/json")
	public ResponseEntity<?> updateUser(@PathVariable Integer user_id, UserModel user) {
		user = userService.update(user_id, user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId()).toUri();
		UserResource resource = new UserResource(user);
		return ResponseEntity.created(location).body(resource);
	}
	

}