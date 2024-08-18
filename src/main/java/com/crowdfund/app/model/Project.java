package com.crowdfund.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "projects")
public class Project {
    @Id
    private String id;
    private String title;
    private String description;
    private double goalAmount;
    private double currentAmount;
    private String status;  // DRAFT, PUBLISHED, FUNDED, ARCHIVED
    private String innovatorId; // User ID
    private List<String> images;
    private List<String> videos;
}