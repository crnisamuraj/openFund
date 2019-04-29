package com.merkaba.samurai.resource;

import com.merkaba.samurai.model.UserModel;

public class UserResource {

	private UserModel user;
	
	public UserResource(UserModel user) {
		this.user = user;
	}

	public UserModel getUser() {
		return user;
	}
	
	
}
