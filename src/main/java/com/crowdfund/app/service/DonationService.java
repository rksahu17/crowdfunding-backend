package com.crowdfund.app.service;

import com.crowdfund.app.model.Donation;
import com.crowdfund.app.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

    public Donation processDonation(Donation donation) {
        return donationRepository.save(donation);
    }

    public List<Donation> getDonationsByProjectId(String projectId) {
        return donationRepository.findByProjectId(projectId);
    }
}