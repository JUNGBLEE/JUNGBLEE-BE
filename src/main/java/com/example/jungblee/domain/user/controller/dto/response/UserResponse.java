package com.example.jungblee.domain.user.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Builder
public class UserResponse {

    private final String username;

    private final String accountId;

    private final int successQuizCount;

    private final int failedQuizCount;
}
