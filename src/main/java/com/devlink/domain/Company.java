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
public class Company {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 기본키 자동 증가
    private Long id;

    private String name; // 회사 이름

    private String email; // 로그인용 이메일

    private String password; // 로그인 비밀 번호

    @Column(length = 1000)
    private String description; //회사 소개

    private String homepageUrl;

    private String logoUrl;

    private LocalDateTime createdAt;

    @PrePersist // insert 되기전에 자동 실행, 엔티티가 처음으로 저장되기 직전에 호출.
    public void setCreatedAt(){
        this.createdAt = LocalDateTime.now();
    }
}
