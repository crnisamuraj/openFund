package com.merkaba.samurai.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.merkaba.samurai.model.UserModel;
import com.merkaba.samurai.resource.UserResource;

@Component
public class UserDao {
	
	private static int userCount = 3;
	
	private static List<UserModel> users = new ArrayList<>();
	
	static {
		users.add(new UserModel(1, "scorpion", "hanzo", "hatori"));
		users.add(new UserModel(2, "samurai", "hasashi", "atari"));
		users.add(new UserModel(3, "sub-zero", "sub", "zero"));
	}
	
	public List<UserResource> findAll() {
		List<UserResource> resources = new ArrayList<UserResource>();
		for (UserModel user:users) {
			UserResource rsc = new UserResource(user);
			resources.add(rsc);
		}
		return resources;
	}
	
	public UserModel add(UserModel user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public UserModel find(Integer id) {
		for (UserModel user:users) {
			if (user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	public UserModel remove (Integer id) {
		UserModel user = this.find(id);
		users.remove(user);
		return user;
	}
	
	public UserModel update (Integer id, UserModel userUpdate) {
		UserModel user = this.find(id);
		if (userUpdate.getUserName() != null) {
			user.setUserName(userUpdate.getUserName());
		}
		if (userUpdate.getPassword() != null) {
			user.setPassword(userUpdate.getPassword());
		}
		if (userUpdate.getFirstName() != null) {
			user.setFirstName(userUpdate.getFirstName());
		}
		if (userUpdate.getLastName() != null) {
			user.setLastName(userUpdate.getLastName());
		}	
		return user;
	}

}
