package com.devlink.repository;

import com.devlink.domain.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
    List<JobPosting> findByCompanyId(Long companyId);// 특정 회사 공고 조회

    //JpaRepository<T, ID> 를 상속하면 기본적인 CRUD 제공
    //findByCompanyId() 처럼 메소드 이름만으로 Where 조건 쿼리를 자동 생성
}
