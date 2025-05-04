package com.csis231.api.controller;

import com.csis231.api.model.Project;
import com.csis231.api.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("api/v1/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@Valid @RequestBody Project project) {
        Project savedProject = projectService.createProject(project);
        return new ResponseEntity<Project>(savedProject, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProject(@PathVariable Long id, @Valid @RequestBody Project projectDetails, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid project data");
        }
        Project updatedProject = projectService.updateProject(id, projectDetails);
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}