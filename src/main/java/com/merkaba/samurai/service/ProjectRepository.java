package com.merkaba.samurai.service;

import com.merkaba.samurai.model.ProjectModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectModel, Integer> {
    
}