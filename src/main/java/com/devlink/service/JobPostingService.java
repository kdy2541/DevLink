package com.devlink.service;

import com.devlink.domain.Company;
import com.devlink.domain.JobPosting;
import com.devlink.dto.JobPostingRequest;
import com.devlink.repository.CompanyRepository;
import com.devlink.repository.JobPostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobPostingService {

    private final JobPostingRepository jobPostingRepository;
    private final CompanyRepository companyRepository;
    public List<JobPosting> getAllJobPostings(Long companyId){
        if(companyId != null){
            return jobPostingRepository.findByCompanyId(companyId);
        }

        return jobPostingRepository.findAll();
    }

    public Optional<JobPosting> getJobPostingById(Long id){
        return jobPostingRepository.findById(id);
    }

    public JobPosting createJobPosting(JobPostingRequest request){
        Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회사입니다."));

        JobPosting posting = JobPosting.builder()
                .title(request.getTitle())
                .position(request.getPosition())
                .salary(request.getSalary())
                .content(request.getContent())
                .deadline(request.getDeadline())
                .company(company)
                .build();

        return jobPostingRepository.save(posting);

    }
}
