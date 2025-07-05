package com.devlink.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//기본키 자동 증가
    private Long id;

    private String username;

    @Column(unique = true) // 이메일 중복 방지 unique 설정
    private String email;

    private String password; // 나중에 Bcrutp

    @Enumerated(EnumType.STRING)
    private Role role; // 유저 권한 설정

    private boolean idDeleted = false; // 탈퇴 처리 여부

    public enum Role{
        ROLE_USER,
        ROLE_COMPANY,
        ROLE_ADMIN
    }


}
