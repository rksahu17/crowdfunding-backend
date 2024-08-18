package com.crowdfund.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "donations")
public class Donation {
    @Id
    private String id;
    private double amount;
    private String donorId;  // User ID
    private String projectId; // Project ID
    private String status; // PENDING, COMPLETED, FAILED
}