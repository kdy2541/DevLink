package com.devlink.repository;

import com.devlink.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    boolean existsByEmail(String email);
    Company findByEmail(String email);
}
