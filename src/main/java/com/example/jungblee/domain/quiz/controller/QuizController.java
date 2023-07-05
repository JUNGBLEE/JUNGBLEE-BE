package com.example.jungblee.domain.quiz.controller;

import com.example.jungblee.domain.quiz.controller.dto.request.QuizCheckRequest;
import com.example.jungblee.domain.quiz.controller.dto.response.QuizListResponse;
import com.example.jungblee.domain.quiz.controller.dto.response.QuizResponse;
import com.example.jungblee.domain.quiz.service.QuizService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/quiz")
@RestController
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/{quizId}")
    public QuizResponse quizDetails(
            @PathVariable Long quizId
    ) {
        return quizService.findQuiz(quizId);
    }

    @PostMapping("/{quizId}")
    public void quizCheck(
            @PathVariable Long quizId,
            @RequestBody QuizCheckRequest request
    ) {
        quizService.checkQuiz(quizId, request);
    }

    @GetMapping("/solvedQuizzes")
    public QuizListResponse solvedQuizList() {
        return quizService.findSolvedQuizList();
    }

    @GetMapping("/failedQuizzes")
    public QuizListResponse failedQuizList() {
        return quizService.findFailedQuizList();
    }

    @GetMapping("/top3")
    public QuizListResponse top3List() {
        return quizService.findTop3ByUser();
    }
}
