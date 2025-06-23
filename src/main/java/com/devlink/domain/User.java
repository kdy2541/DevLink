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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean idDeleted = false;

    public enum Role{
        ROLE_USER,
        ROLE_COMPANY,
        ROLE_ADMIN
    }


}
