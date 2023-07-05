package com.example.jungblee.domain.videoquiz.controller.dto.response;

import com.example.jungblee.domain.user.entity.User;
import com.example.jungblee.domain.videoquiz.entity.VideoQuiz;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
public class VideoQuizOpinionListResponse {

    private final List<VideoQuizOpinionResponse> videoQuizOpinionResponses;

    @Getter
    @Builder
    public class VideoQuizOpinionResponse {
        private final Long id;
        private final  String content;
        private final boolean team;
        private final String username;
    }
}
