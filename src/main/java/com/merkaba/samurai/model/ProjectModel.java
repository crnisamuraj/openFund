package com.merkaba.samurai.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "Project")
@EntityListeners(AuditingEntityListener.class)
public class ProjectModel {

    @Id
	@GeneratedValue
    private Integer id;

    private String name;

    private String description;

    @OneToOne
    @JoinColumn(name = "owner")
    @JsonBackReference
    private UserModel owner;

    @Temporal(TemporalType.DATE)
    //@CreatedDate
    private Date creationDate;

    @Temporal(TemporalType.DATE)
	@LastModifiedDate
    private Date lastModified;

    @Temporal(TemporalType.DATE)
    private Date endDate;



    public ProjectModel() {
    }

    public ProjectModel(Integer id, String name, String description, UserModel owner, Date endDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.endDate = endDate;
    }

    public ProjectModel(ProjectModel project) {

        this.id = project.id;
        this.name = project.name;
        this.description = project.description;
        this.owner = project.owner;
        this.endDate = project.endDate;
    }



    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the owner
     */
    public UserModel getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(UserModel owner) {
        this.owner = owner;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the lastModified
     */
    public Date getLastModified() {
        return lastModified;
    }

    /**
     * @param lastModified the lastModified to set
     */
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    

    
}