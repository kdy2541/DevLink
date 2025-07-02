package com.devlink.controller;

import com.devlink.domain.JobPosting;
import com.devlink.dto.JobPostingRequest;
import com.devlink.service.JobPostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job-postings")
@RequiredArgsConstructor
public class JobPostingController {

    private final JobPostingService jobPostingService;

    @GetMapping
    public ResponseEntity<List<JobPosting>> getAllJobPostings(@RequestParam(required = false) Long companyId){
        List<JobPosting> postings = jobPostingService.getAllJobPostings(companyId);
        return ResponseEntity.ok(postings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPosting> getJobPosting(@PathVariable Long id){
        return jobPostingService.getJobPostingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<JobPosting> createJobPosting(@RequestBody JobPostingRequest request){
        JobPosting saved = jobPostingService.createJobPosting(request);
        return ResponseEntity.ok(saved);
    }


}
