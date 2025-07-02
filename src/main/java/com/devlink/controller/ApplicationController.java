package com.devlink.controller;

import com.devlink.domain.Application;
import com.devlink.dto.ApplicationRequest;
import com.devlink.service.ApplicationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody ApplicationRequest request){
        Application saved = applicationService.createApplication(request);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/users/{userId}/applications")
    public ResponseEntity<List<Application>> getApplicationsByUserId(@PathVariable Long userId){
        List<Application> applications = applicationService.getApplicationsByUserId(userId);
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/job-postings/{jobPostingId}/applications")
    public ResponseEntity<List<Application>> getApplicationsByJobPostingId(@PathVariable Long jobPostingId) {
        List<Application> applications = applicationService.getApplicationsByJobPostingId(jobPostingId);
        return ResponseEntity.ok(applications);
    }

}
