package com.example.jungblee.domain.videoquiz.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "tbl_video_quiz")
public class VideoQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_quiz_id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "photo", nullable = false)
    private String photo;

    @Column(name = "answer", nullable = false)
    private String answer;

    @Column(name = "issuedAt", nullable = false)
    private LocalDate issuedAt;
/*
    @OneToMany(mappedBy = "video_quiz")
    private List<VideoQuizOpinion> opinionList;*/

    @Builder
    public VideoQuiz(
            String title,
            String content,
            String photo,
            String answer
    ) {
        this.title = title;
        this.content = content;
        this.photo = photo;
        this.answer = answer;
    }
}
