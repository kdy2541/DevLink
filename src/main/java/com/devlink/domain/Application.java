package com.devlink.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;// 지원자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_posting_id")
    private JobPosting jobPosting;// 지원 대상 공고

    private LocalDateTime appliedAt;

    @Column(length = 1000)
    private String coverLetter; // 자기소개서

    @PrePersist
    public void setAppliedAt(){
        this.appliedAt = LocalDateTime.now();
    }
}
