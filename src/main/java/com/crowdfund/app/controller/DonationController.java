package com.crowdfund.app.controller;

import com.crowdfund.app.model.Donation;
import com.crowdfund.app.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donations")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @PostMapping
    public Donation createDonation(@RequestBody Donation donation) {
        return donationService.processDonation(donation);
    }

    @GetMapping("/project/{projectId}")
    public List<Donation> getDonationsByProjectId(@PathVariable String projectId) {
        return donationService.getDonationsByProjectId(projectId);
    }
}
