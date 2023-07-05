package com.example.jungblee.domain.videoquiz.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VideoQuizOpinionResponse {
    private final Long id;
    private final String content;
    private final boolean team;
    private final String username;
}
