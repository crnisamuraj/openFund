package com.merkaba.samurai.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "role")
public class Role {
    
    @Id
    @GeneratedValue
    private Integer id;

    @NaturalId
    @Enumerated(EnumType.STRING)
    private RoleName role;

    public Role() {

    }

    public Role(RoleName role) {
        this.role = role;
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
     * @return the role
     */
    public RoleName getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(RoleName role) {
        this.role = role;
    }

    


}