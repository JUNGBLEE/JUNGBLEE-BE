package com.example.jungblee.domain.videoquiz.controller;

import com.example.jungblee.domain.videoquiz.controller.dto.request.VideoQuizOpinionCreateRequest;
import com.example.jungblee.domain.videoquiz.controller.dto.response.VideoQuizListResponse;
import com.example.jungblee.domain.videoquiz.controller.dto.response.VideoQuizMaximumResponse;
import com.example.jungblee.domain.videoquiz.service.VideoQuizOpinionService;
import com.example.jungblee.domain.videoquiz.service.VideoQuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public VideoQuizMaximumResponse videoQuizList(
            @PathVariable Long videoQuizId
    ) {
        return videoQuizService.findVideoQuiz(videoQuizId);
    }
}
