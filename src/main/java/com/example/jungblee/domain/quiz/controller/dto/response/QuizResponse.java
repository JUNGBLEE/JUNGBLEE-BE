package com.example.jungblee.domain.quiz.controller.dto.response;

import com.example.jungblee.domain.quiz.entity.Quiz;
import com.example.jungblee.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QuizResponse {

    private final Long id;

    private final String content;

    private final String commentary;

    private final String answer;

    private final boolean isMultipleChose;

    private final String optionA;

    private final String optionB;

    private final String optionC;

    private final String optionD;

    private final boolean successful;

    private final String accountId;

    public static QuizResponse of(
            Quiz quiz
    ) {

        if (quiz.isMultipleChose()) {
            return QuizResponse.builder()
                    .id(quiz.getId())
                    .content(quiz.getContent())
                    .commentary(quiz.getCommentary())
                    .answer(quiz.getAnswer())

                    .successful(quiz.isSuccessful())
                    .accountId(quiz.getUser().getAccountId())

                    .isMultipleChose(true)
                    .optionA(quiz.getOptionA())
                    .optionB(quiz.getOptionB())
                    .optionC(quiz.getOptionC())
                    .optionD(quiz.getOptionD())
                    .build();
        }

        return QuizResponse.builder()
                .id(quiz.getId())
                .content(quiz.getContent())
                .commentary(quiz.getCommentary())
                .answer(quiz.getAnswer())

                .successful(quiz.isSuccessful())
                .accountId(quiz.getUser().getAccountId())

                .isMultipleChose(false)
                .build();
    }
}
