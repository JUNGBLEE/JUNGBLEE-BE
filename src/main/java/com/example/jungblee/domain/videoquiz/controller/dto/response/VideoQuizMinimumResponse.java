package com.example.jungblee.domain.videoquiz.controller.dto.response;

import com.example.jungblee.domain.videoquiz.entity.VideoQuiz;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Builder
public class VideoQuizMinimumResponse {

    private final Long id;

    private final String title;

    private final String content;

    private final String photo;

    private final LocalDate issuedAt;

    public static VideoQuizMinimumResponse of(
            VideoQuiz videoQuiz
    ) {
        return VideoQuizMinimumResponse.builder()
                .id(videoQuiz.getId())
                .title(videoQuiz.getTitle())
                .content(videoQuiz.getContent())
                .photo(videoQuiz.getPhoto())
                .issuedAt(videoQuiz.getIssuedAt())
                .build();
    }
}
