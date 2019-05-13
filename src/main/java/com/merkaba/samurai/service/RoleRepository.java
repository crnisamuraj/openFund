package com.merkaba.samurai.service;

import java.util.Optional;

import com.merkaba.samurai.model.Role;
import com.merkaba.samurai.model.RoleName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    
    Optional<Role> findByName(RoleName roleName);

}