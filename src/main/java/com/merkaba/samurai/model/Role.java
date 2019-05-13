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
    private RoleName name;

    public Role() {

    }

    public Role(RoleName name) {
        this.name = name;
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
    public RoleName getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setRole(RoleName name) {
        this.name = name;
    }

    


}