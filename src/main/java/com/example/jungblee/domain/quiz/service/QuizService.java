package com.example.jungblee.domain.quiz.service;

import com.example.jungblee.domain.quiz.controller.dto.request.QuizCheckRequest;
import com.example.jungblee.domain.quiz.controller.dto.response.QuizListResponse;
import com.example.jungblee.domain.quiz.controller.dto.response.QuizResponse;
import com.example.jungblee.domain.quiz.entity.Quiz;
import com.example.jungblee.domain.quiz.repository.QuizRepository;
import com.example.jungblee.domain.user.entity.User;
import com.example.jungblee.domain.user.repository.UserRepository;
import com.example.jungblee.domain.user.service.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuizService {

    private final QuizRepository quizRepository;

    private final UserFacade userFacade;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public QuizResponse findQuiz(Long quizId) {

        return QuizResponse.of(
                quizRepository.findById(quizId)
                        .orElseThrow(() -> new RuntimeException()));
    }

    @Transactional
    public void checkQuiz(
            Long quizId,
            QuizCheckRequest request
    ) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException());

        User user = userFacade.currentUser();

        if (quiz.getAnswer().equals(request.getAnswer()))
            quiz.solveQuiz(user, true);
        else
            quiz.solveQuiz(user, false);

        quizRepository.save(quiz);
    }

    @Transactional(readOnly = true)
    public QuizListResponse findSolvedQuizList() {

        User user = userFacade.currentUser();

        List<Quiz> quizList = quizRepository.findAllByUserAndSuccessfulOrderByIdDesc(user, true);
        if (quizList == null)
            return null;

        return new QuizListResponse(
                quizList
                .stream()
                .map(QuizResponse::of)
                .toList());
    }

    @Transactional(readOnly = true)
    public QuizListResponse findTop3ByUser() {

        User user = userFacade.currentUser();

        List<Quiz> quizList = quizRepository.findTop3ByUserOrderByIdDesc(user);
        if (quizList == null)
            return null;

        return new QuizListResponse(
                quizList
                        .stream()
                        .map(QuizResponse::of)
                        .toList());
    }

    @Transactional(readOnly = true)
    public QuizListResponse findFailedQuizList() {

        User user = userFacade.currentUser();
        List<Quiz> quizList = quizRepository.findAllByUserAndSuccessfulOrderByIdDesc(user, false);

        return new QuizListResponse(
                quizList
                .stream()
                .map(QuizResponse::of)
                .toList());
    }
}
