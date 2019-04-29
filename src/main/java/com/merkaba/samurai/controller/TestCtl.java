package com.merkaba.samurai.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.merkaba.samurai.model.UserModel;
import com.merkaba.samurai.service.UserDao;

@RestController
@RequestMapping("/test")
public class TestCtl {
	
	@Autowired
	private UserDao userService;
	
	@RequestMapping(method=RequestMethod.GET, path="/helloworld", produces="application/json")
	public ResponseEntity<?> test() {
		HashMap <String,Object> root = new HashMap<>();
		HashMap<String,String> data = new HashMap<>();
		data.put("Success","True");
		data.put("userName", "username");
		data.put("creationDate", "creationDate");
		root.put("Data", data);
		return ResponseEntity.ok(root);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/filtering", produces="application/json")
	public ResponseEntity<MappingJacksonValue> filtering() {
		List<UserModel> users = userService.findAll();
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName", "password");
		FilterProvider filters = new SimpleFilterProvider().addFilter("filter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(users);
		mapping.setFilters(filters);
		//TODO add @JsonFilter("filter") to UserModel to enable this filter
		return new ResponseEntity<MappingJacksonValue>(mapping, HttpStatus.OK);
	}

}
