package com.devlink.controller;

import com.devlink.domain.Application;
import com.devlink.dto.ApplicationRequest;
import com.devlink.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
