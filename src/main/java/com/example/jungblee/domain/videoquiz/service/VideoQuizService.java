package com.example.jungblee.domain.videoquiz.service;

import com.example.jungblee.domain.videoquiz.controller.dto.request.VideoQuizTeamSelectRequest;
import com.example.jungblee.domain.videoquiz.controller.dto.response.VideoQuizListResponse;
import com.example.jungblee.domain.videoquiz.controller.dto.response.VideoQuizMaximumResponse;
import com.example.jungblee.domain.videoquiz.controller.dto.response.VideoQuizMinimumResponse;
import com.example.jungblee.domain.videoquiz.entity.VideoQuiz;
import com.example.jungblee.domain.videoquiz.repository.VideoQuizOpinionRepository;
import com.example.jungblee.domain.videoquiz.repository.VideoQuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class VideoQuizService {

    private final VideoQuizRepository videoQuizRepository;

    private final VideoQuizOpinionRepository videoQuizOpinionRepository;

    @Transactional(readOnly = true)
    public VideoQuizListResponse findVideoQuizList() {

        return new VideoQuizListResponse(
                videoQuizRepository.findAll()
                        .stream()
                        .map(VideoQuizMinimumResponse::of)
                        .toList());
    }

    @Transactional(readOnly = true)
    public VideoQuizMaximumResponse findVideoQuiz(
            Long videoQuizId
    ) {
        return VideoQuizMaximumResponse.of(
                videoQuizRepository.findById(videoQuizId)
                        .orElseThrow(() -> new RuntimeException()));
    }

    @Transactional
    public void selectTeam(
            Long videoQuizId,
            VideoQuizTeamSelectRequest request
    ) {

        VideoQuiz videoQuiz = videoQuizRepository.findById(videoQuizId)
                .orElseThrow(() -> new RuntimeException());
        if (request.isTeam())
            videoQuiz.selectTeamA();
        else
            videoQuiz.selectTeamB();
    }
}
