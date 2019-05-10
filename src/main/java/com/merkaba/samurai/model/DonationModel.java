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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "Donation")
@EntityListeners(AuditingEntityListener.class)
public class DonationModel {
    
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user")
    private UserModel user;

    @OneToOne
    private ProjectModel project;

    private String currency;
    
    private Float amount;

    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date creationDate;


    public DonationModel(Integer id, UserModel user, ProjectModel project, String currency, Float amount, Date creationDate) {
        this.id = id;
        this.user = user;
        this.project = project;
        this.currency = currency;
        this.amount = amount;
        this.creationDate = new Date();
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserModel getUser() {
        return this.user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public ProjectModel getProject() {
        return this.project;
    }

    public void setProject(ProjectModel project) {
        this.project = project;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Float getAmount() {
        return this.amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", user='" + getUser() + "'" +
            ", project='" + getProject() + "'" +
            ", currency='" + getCurrency() + "'" +
            ", amount='" + getAmount() + "'" +
            ", creationDate='" + getCreationDate() + "'" +
            "}";
    }


}