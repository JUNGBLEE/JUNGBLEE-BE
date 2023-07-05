package com.example.jungblee.domain.videoquiz.controller;

import com.example.jungblee.domain.videoquiz.controller.dto.request.VideoQuizOpinionCreateRequest;
import com.example.jungblee.domain.videoquiz.controller.dto.response.VideoQuizOpinionListResponse;
import com.example.jungblee.domain.videoquiz.service.VideoQuizOpinionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/video-quiz/opinion")
@RestController
public class VideoQuizOpinionController {

    private final VideoQuizOpinionService videoQuizOpinionService;

    @GetMapping("/{videoQuizId}")
    public VideoQuizOpinionListResponse videoOpinionList(
            @PathVariable Long videoQuizId
    ) {
        return videoQuizOpinionService.findOpinionList(videoQuizId);
    }

    @PostMapping("/{videoQuizId}")
    public void videoQuizOpinionAdd(
            @PathVariable Long videoQuizId,
            @RequestBody @Valid VideoQuizOpinionCreateRequest request
    ) {
        videoQuizOpinionService.addOpinion(videoQuizId, request);
    }
}
