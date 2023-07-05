package com.example.jungblee.domain.videoquiz.controller.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class VideoQuizListResponse {

    private final List<VideoQuizMinimumResponse> responseList;
}
