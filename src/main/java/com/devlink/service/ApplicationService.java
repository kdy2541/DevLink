package com.devlink.service;

import com.devlink.domain.Application;
import com.devlink.domain.JobPosting;
import com.devlink.domain.User;
import com.devlink.dto.ApplicationRequest;
import com.devlink.repository.ApplicationRepository;
import com.devlink.repository.JobPostingRepository;
import com.devlink.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final JobPostingRepository jobPostingRepository;

    public Application createApplication(ApplicationRequest request){
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        JobPosting jobPosting = jobPostingRepository.findById(request.getJobPostingId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 채용공고입니다."));

        Application application = Application.builder()
                .user(user)
                .jobPosting(jobPosting)
                .coverLetter(request.getCoverLetter())
                .build();

        return applicationRepository.save(application);
    }

    public List<Application> getApplicationsByUserId(Long userId){
        return applicationRepository.findByUserId(userId);
    }

    public List<Application> getApplicationsByJobPostingId(Long jobPostingId){
        return applicationRepository.findByJobPostingId(jobPostingId);
    }
}
