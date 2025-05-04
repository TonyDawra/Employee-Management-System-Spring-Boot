package com.csis231.api.service;

import com.csis231.api.exception.ResourceNotFoundException;
import com.csis231.api.model.Project;
import com.csis231.api.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found"));
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Long id, Project projectDetails) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found"));

        System.err.println(projectDetails.getEmployeeName());

        project.setEmployeeName(projectDetails.getEmployeeName());
        project.setProjectName(projectDetails.getProjectName());
        project.setProjectDescription(projectDetails.getProjectDescription());
        project.setProjectStart(projectDetails.getProjectStart());
        project.setProjectEnd(projectDetails.getProjectEnd());
        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        projectRepository.delete(project);
    }

    // Update and delete methods would need to be customized based on the fields of the Project class
}