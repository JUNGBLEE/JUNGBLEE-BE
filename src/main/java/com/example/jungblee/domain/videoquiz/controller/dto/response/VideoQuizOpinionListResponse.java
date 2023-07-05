package com.example.jungblee.domain.videoquiz.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class VideoQuizOpinionListResponse {

    private final List<VideoQuizOpinionResponse> videoQuizOpinionResponseList;

}
