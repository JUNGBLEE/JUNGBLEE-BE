package com.example.jungblee.domain.auth.controller.dto.response;

import lombok.*;

@Getter
@AllArgsConstructor
public class TokenResponse {
    private final String accessToken;
}
