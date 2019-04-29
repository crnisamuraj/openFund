package com.merkaba.samurai.resource;

import java.util.Date;

import com.merkaba.samurai.model.UserModel;

public class UserResource {
	
	private Integer id;
	
	private String userName;
	
	private String firstName;
	
	private String lastName;

	private Date creationDate;
	
	private Date modifiedAt;
	
	
	public UserResource() {
		super();
	}
	
	public UserResource(UserModel user) {
		this.id = user.getId();
		this.userName = user.getUserName();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.creationDate = user.getCreationDate();
		this.modifiedAt = user.getModifiedAt();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@Override
	public String toString() {
		return "UserResource [id=" + id + ", userName=" + userName + ", firstName="
				+ firstName + ", lastName=" + lastName + ", creationDate=" + creationDate + ", modifiedAt=" + modifiedAt
				+ "]";
	}
	
	

}
