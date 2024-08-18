package com.crowdfund.app.repository;

import com.crowdfund.app.model.Donation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DonationRepository extends MongoRepository<Donation, String> {
    List<Donation> findByProjectId(String projectId);
}
