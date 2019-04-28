package com.merkaba.samurai.controller;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestCtl {
	
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

}
