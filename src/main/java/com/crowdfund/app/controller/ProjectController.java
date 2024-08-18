package com.crowdfund.app.controller;

import com.crowdfund.app.model.Project;
import com.crowdfund.app.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PutMapping("/{id}/publish")
    public Project publishProject(@PathVariable String id) {
        return projectService.publishProject(id);
    }

    @PutMapping("/{id}/archive")
    public Project archiveProject(@PathVariable String id) {
        return projectService.archiveProject(id);
    }

    @GetMapping("/user/{innovatorId}")
    public List<Project> getProjectsByUser(@PathVariable String innovatorId) {
        return projectService.getProjectsByUser(innovatorId);
    }
}