package com.example.jungblee.domain.videoquiz.entity;

import com.example.jungblee.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "tbl_opinion")
public class VideoQuizOpinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "opinion_id")
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "team", nullable = false)
    private boolean team;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "video_quiz_id")
    private VideoQuiz videoQuiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public VideoQuizOpinion(
            String content,
            boolean team,
            VideoQuiz videoQuiz,
            User user
    ) {
        this.content = content;
        this.team = team;
        this.videoQuiz = videoQuiz;
        this.user = user;
    }
}
