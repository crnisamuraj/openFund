package com.merkaba.samurai.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.merkaba.samurai.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>{

}
