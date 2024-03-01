package com.example.manytomanyrestapi.controller;

import com.example.manytomanyrestapi.entity.Project;
import com.example.manytomanyrestapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
@Autowired
    private ProjectService projectService;
    @PostMapping("/save")
    public ResponseEntity createProject(@RequestBody Project project){
        projectService.saveProject(project);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping("/getProjects/{projId}")
    public List<Project> getProjects(@PathVariable int projId){
        return projectService.getProjectDetails(projId);
    }
    @DeleteMapping("/deleteProject/{projId}")
    public ResponseEntity removeProject(@PathVariable int projId){
        projectService.deleteProject(projId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
