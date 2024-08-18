package com.crowdfund.app.service;

import com.crowdfund.app.model.Project;
import com.crowdfund.app.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findByStatus("PUBLISHED");
    }

    public Project publishProject(String projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        project.setStatus("PUBLISHED");
        return projectRepository.save(project);
    }

    public Project archiveProject(String projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        project.setStatus("ARCHIVED");
        return projectRepository.save(project);
    }
}
