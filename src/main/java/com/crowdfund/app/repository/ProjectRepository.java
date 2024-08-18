package com.crowdfund.app.repository;

import com.crowdfund.app.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProjectRepository extends MongoRepository<Project, String> {
    List<Project> findByStatus(String status);
    List<Project> findByInnovatorId(String innovatorId);
}
