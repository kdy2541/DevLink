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
public class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // 공고 제목

    private String position; // 모집 직무

    private String salary; // 연봉

    @Column(length = 2000)
    private String content; // 공고 상세 설명

    private LocalDateTime createdAt;

    private LocalDateTime deadline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id") // FK 연결
    private Company company; //공고를 등록한 회사

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }
}
