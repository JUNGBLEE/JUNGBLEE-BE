package com.example.jungblee.domain.quiz.entity;

import com.example.jungblee.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "tbl_quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "commentary", nullable = false)
    private String commentary;

    @Column(name = "answer", nullable = false)
    private String answer;

    @Column(name = "type", nullable = false)
    private boolean isMultipleChose;

    @Column(name = "option_a")
    private String optionA = null;

    @Column(name = "option_b")
    private String optionB = null;

    @Column(name = "option_c")
    private String optionC = null;

    @Column(name = "option_d")
    private String optionD = null;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "successful")
    private boolean successful = false;

    public void solveQuiz(User user, boolean successful) {
        this.user = user;
        this.successful = successful;
    }
}
