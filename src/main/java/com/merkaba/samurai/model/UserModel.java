package com.merkaba.samurai.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.merkaba.samurai.model.DateAudit;

import org.hibernate.annotations.NaturalId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name="User")
public class UserModel extends DateAudit{


	/* =================== *
	 * === Properties  === *
	 * =================== */


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@NaturalId
	@Column(unique = true)
	@NotNull(message="User Name cannot be empty")
	private String userName;
	
	@NotNull(message="Password cannot be empty")
	private String password;

	@Email
	@Column(unique = true)
	private String email;
	
	private String firstName;
	
	private String lastName;

	@ManyToMany
	@JoinTable(name = "user_roles",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@OneToMany(mappedBy = "owner")
	@JsonManagedReference
	private List<ProjectModel> projects;

	@OneToMany(mappedBy = "user")
	private List<DonationModel> donations;

	@Temporal(TemporalType.DATE)
    @CreatedDate
	private Date creationDate;
	
	@Temporal(TemporalType.DATE)
	@LastModifiedDate
	private Date modifiedAt;


	/* =================== *
	 * === Constructor === *
	 * =================== */


	public UserModel() {

	}
	
	public UserModel(String userName, String password, String email, String firstName, String lastName) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	/* =================== *
	 * Getters and Setters *
	 * =================== */
	

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public List<ProjectModel> getProjects() {
		return this.projects;
	}

	public void setProjects(List<ProjectModel> projects) {
		this.projects = projects;
	}

	public List<DonationModel> getDonations() {
		return this.donations;
	}

	public void setDonations(List<DonationModel> donations) {
		this.donations = donations;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModifiedAt() {
		return this.modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}



	
}
