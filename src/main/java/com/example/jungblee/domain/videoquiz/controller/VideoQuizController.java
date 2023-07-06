package com.example.jungblee.domain.videoquiz.controller;

import com.example.jungblee.domain.videoquiz.controller.dto.request.VideoQuizTeamSelectRequest;
import com.example.jungblee.domain.videoquiz.controller.dto.response.VideoQuizListResponse;
import com.example.jungblee.domain.videoquiz.controller.dto.response.VideoQuizMaximumResponse;
import com.example.jungblee.domain.videoquiz.service.VideoQuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/video-quiz")
@RestController
public class VideoQuizController {

    private final VideoQuizService videoQuizService;

    @GetMapping("/list")
    public VideoQuizListResponse videoQuizList() {
        return videoQuizService.findVideoQuizList();
    }

    @GetMapping("/{videoQuizId}")
    public VideoQuizMaximumResponse videoQuizDetails(
            @PathVariable Long videoQuizId
    ) {
        return videoQuizService.findVideoQuiz(videoQuizId);
    }

    @PostMapping("/{videoQuizId}")
    public void selectTeamB(
            @PathVariable Long videoQuizId,
            @RequestBody VideoQuizTeamSelectRequest request
    ) {
        videoQuizService.selectTeam(videoQuizId, request);
    }
}
