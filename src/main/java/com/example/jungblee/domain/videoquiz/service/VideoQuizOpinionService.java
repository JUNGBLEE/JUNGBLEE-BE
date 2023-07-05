package com.example.jungblee.domain.videoquiz.service;

import com.example.jungblee.domain.user.entity.User;
import com.example.jungblee.domain.user.service.UserFacade;
import com.example.jungblee.domain.videoquiz.controller.dto.request.VideoQuizOpinionCreateRequest;
import com.example.jungblee.domain.videoquiz.controller.dto.response.VideoQuizOpinionListResponse;
import com.example.jungblee.domain.videoquiz.controller.dto.response.VideoQuizOpinionResponse;
import com.example.jungblee.domain.videoquiz.entity.VideoQuiz;
import com.example.jungblee.domain.videoquiz.entity.VideoQuizOpinion;
import com.example.jungblee.domain.videoquiz.repository.VideoQuizOpinionRepository;
import com.example.jungblee.domain.videoquiz.repository.VideoQuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VideoQuizOpinionService {
    private final VideoQuizRepository videoQuizRepository;
    private final VideoQuizOpinionRepository videoQuizOpinionRepository;
    private final UserFacade userFacade;

    @Transactional
    public void addOpinion(
            Long videoQuizId,
            VideoQuizOpinionCreateRequest request
    ) {
        User user = userFacade.currentUser();
        VideoQuiz videoQuiz = videoQuizRepository.findById(videoQuizId)
                .orElseThrow(() -> new RuntimeException());

        videoQuizOpinionRepository.save(
                VideoQuizOpinion.builder()
                        .content(request.getContent())
                        .team(request.isTeam())
                        .videoQuiz(videoQuiz)
                        .user(user)
                        .build());
    }

    @Transactional(readOnly = true)
    public VideoQuizOpinionListResponse findOpinionList(Long videoQuizId) {

        VideoQuiz videoQuiz = videoQuizRepository.findById(videoQuizId)
                .orElseThrow(() -> new RuntimeException());

        User user = userFacade.currentUser();

        List<VideoQuizOpinionResponse> videoQuizOpinionResponseList = videoQuizOpinionRepository.findAllByVideoQuizOrderByIdDesc(videoQuiz)
                .stream()
                .map(videoQuizOpinion ->
                        VideoQuizOpinionResponse.builder()
                                .id(videoQuizOpinion.getId())
                                .username(user.getUsername())
                                .content(videoQuizOpinion.getContent())
                                .team(videoQuizOpinion.isTeam())
                                .build())
                .toList();

        return new VideoQuizOpinionListResponse(videoQuizOpinionResponseList);
    }
}
