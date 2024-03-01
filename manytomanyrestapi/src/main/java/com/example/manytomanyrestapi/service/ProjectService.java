package com.example.manytomanyrestapi.service;

import com.example.manytomanyrestapi.entity.Project;
import com.example.manytomanyrestapi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public void saveProject(Project project){
        projectRepository.save(project);
    }

    public List<Project>getProjectDetails(int projId){
        return projectRepository.findAll();

    }

    public void deleteProject(int projId){
        projectRepository.deleteById(projId);
    }

}
