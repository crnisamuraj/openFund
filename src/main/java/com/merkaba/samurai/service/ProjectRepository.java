package com.merkaba.samurai.service;

import java.util.List;

import com.merkaba.samurai.model.ProjectModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectModel, Integer> {
    
    @Query(value = "SELECT p FROM ProjectModel p JOIN p.owner u WHERE u.id = ?1")
    List<ProjectModel> getProjectsByUserId (Integer id);

}