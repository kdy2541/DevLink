package com.devlink.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class JobPostingRequest {
    private String title;
    private String position;
    private String salary;
    private String content;
    private LocalDateTime deadline;
    private Long companyId;
}
