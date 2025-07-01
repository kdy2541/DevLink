package com.devlink.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationRequest {
    private Long jobPostingId;
    private Long userId;
    private String coverLetter;
}
