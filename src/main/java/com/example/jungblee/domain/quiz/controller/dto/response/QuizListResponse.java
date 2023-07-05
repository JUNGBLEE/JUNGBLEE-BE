package com.example.jungblee.domain.quiz.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

@Getter
@AllArgsConstructor
public class QuizListResponse {
    private final List<QuizResponse> quizResponseList;
}
