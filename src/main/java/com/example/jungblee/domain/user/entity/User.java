package com.example.jungblee.domain.user.entity;

import com.example.jungblee.domain.quiz.entity.Quiz;
import com.example.jungblee.domain.videoquiz.entity.VideoQuizOpinion;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username", length = 10, nullable = false)
    private String username;

    @Column(name = "account_id", length = 20, nullable = false)
    private String accountId;

    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Quiz> quizList;

    @OneToMany(mappedBy = "user")
    private List<VideoQuizOpinion> opinionList;

    @Builder
    public User(String username, String accountId, String password, List<Quiz> quizList) {
        this.username = username;
        this.accountId = accountId;
        this.password = password;
        this.quizList = quizList;
    }
}
