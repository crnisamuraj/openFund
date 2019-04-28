package com.merkaba.samurai.model;

import java.util.Date;

public class UserModel {

	/* =================== *
	 * === Properties  === *
	 * =================== */
	
	private Integer id;
	
	private String userName;
	
	private String password;
	
	private String firstName;
	
	private String lastName;

	private Date creationDate;

	/* =================== *
	 * === Constructor === *
	 * =================== */

	public UserModel() {
		super();
		this.creationDate = new Date();
	}
	
	public UserModel(Integer id, String userName, String firstName, String lastName) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.creationDate = new Date();
	}

	/* =================== *
	 * Getters and Setters *
	 * =================== */
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", creationDate=" + creationDate + "]";
	}
	
	
}
