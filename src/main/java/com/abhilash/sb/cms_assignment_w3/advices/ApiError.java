package com.abhilash.sb.cms_assignment_w3.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiError {
    private String message;
    private LocalDateTime timeStamp;
    private HttpStatus status;
}
