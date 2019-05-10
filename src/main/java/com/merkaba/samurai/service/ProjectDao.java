package com.merkaba.samurai.service;

import java.util.List;
import java.util.Optional;

import com.merkaba.samurai.model.ProjectModel;
import com.merkaba.samurai.model.UserModel;
import com.merkaba.samurai.util.exception.CustomException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectDao {
    
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;

    
    public List<ProjectModel> findAll() {
        List<ProjectModel> projects = projectRepository.findAll();
        if (projects.isEmpty())
            throw new CustomException("no users found", HttpStatus.NOT_FOUND);
        return projects;
    }

    public ProjectModel find(Integer id) {
        Optional<ProjectModel> retVal = projectRepository.findById(id);
        if (retVal.isEmpty()) {
            throw new CustomException("User with id: " + id + "not found", HttpStatus.NOT_FOUND);
        }
        ProjectModel project = new ProjectModel(retVal.get());
        return project;
        
    }

    public ProjectModel add(Integer userId, ProjectModel project) {
        try {
            Optional<UserModel> user = userRepository.findById(userId);
            project.setOwner(user.get());
            ProjectModel retVal = projectRepository.save(project);
            return retVal;
        } catch (Exception e) {
            throw new CustomException(e.getMessage().toString(), HttpStatus.BAD_REQUEST);
        }        
    }

    public String remove(Integer id) {
        try {
            projectRepository.deleteById(id);
            return "User with id: " + id + "removed.";
        } catch (Exception e) {
            throw new CustomException(e.getMessage().toString(), HttpStatus.NOT_MODIFIED);
        }
    }

    public ProjectModel update(Integer id, ProjectModel projectU) {
        try {
            projectU.setId(id);
            ProjectModel retVal = projectRepository.save(projectU);
            return retVal;
        } catch (Exception e) {
            throw new CustomException(e.getMessage().toString(), HttpStatus.NOT_MODIFIED);
        }
    }

    public List<ProjectModel> getProjectsByUserId (Integer id) {
        List<ProjectModel> projects = projectRepository.getProjectsByUserId(id);
        if (projects.isEmpty()) {
            throw new CustomException("no projects found", HttpStatus.NOT_FOUND);
        }
        return projects;
    }


}