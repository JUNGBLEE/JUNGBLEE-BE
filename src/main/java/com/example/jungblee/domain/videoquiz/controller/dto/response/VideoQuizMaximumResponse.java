package com.example.jungblee.domain.videoquiz.controller.dto.response;

import com.example.jungblee.domain.videoquiz.entity.VideoQuiz;
import com.example.jungblee.domain.videoquiz.entity.VideoQuizOpinion;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Builder
public class VideoQuizMaximumResponse {

    private final Long id;

    private final String title;

    private final String content;

    private final String photo;

    private final String answer;

    private final LocalDate issuedAt;

    private final List<VideoQuizOpinion> opinionList;

    public static VideoQuizMaximumResponse of(
            VideoQuiz videoQuiz
    ) {
        return VideoQuizMaximumResponse.builder()
                .id(videoQuiz.getId())
                .title(videoQuiz.getTitle())
                .content(videoQuiz.getContent())
                .photo(videoQuiz.getPhoto())
                .answer(videoQuiz.getAnswer())
                .issuedAt(videoQuiz.getIssuedAt())
                .build();
    }
}
