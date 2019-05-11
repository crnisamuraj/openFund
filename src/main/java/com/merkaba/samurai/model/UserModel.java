package com.merkaba.samurai.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="User")
@EntityListeners(AuditingEntityListener.class)
public class UserModel {

	/* =================== *
	 * === Properties  === *
	 * =================== */
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotNull(message="User Name cannot be empty")
	private String userName;
	
	@NotNull(message="Password cannot be empty")
	private String password;
	
	private String firstName;
	
	private String lastName;

	@OneToMany(mappedBy = "owner")
	@JsonManagedReference
	private List<ProjectModel> projects;

	@OneToMany(mappedBy = "user")
	private List<DonationModel> donations;

	@Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
	private Date creationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date modifiedAt;

	/* =================== *
	 * === Constructor === *
	 * =================== */

	public UserModel() {
		super();
	}
	
	public UserModel(Integer id, String userName, String password, String firstName, String lastName) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
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

	
	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}


	public List<ProjectModel> getProjects() {
		return this.projects;
	}

	public void setProjects(List<ProjectModel> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "UserModel [creationDate=" + creationDate + ", firstName=" + firstName + ", id=" + id + ", lastName="
				+ lastName + ", modifiedAt=" + modifiedAt + ", password=" + password + ", projects=" + projects
				+ ", userName=" + userName + "]";
	}

	
	
}
