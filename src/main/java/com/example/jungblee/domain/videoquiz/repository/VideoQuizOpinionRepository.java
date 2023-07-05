package com.example.jungblee.domain.videoquiz.repository;

import com.example.jungblee.domain.videoquiz.entity.VideoQuiz;
import com.example.jungblee.domain.videoquiz.entity.VideoQuizOpinion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoQuizOpinionRepository extends JpaRepository<VideoQuizOpinion, Long> {

    List<VideoQuizOpinion> findAllByVideoQuizOrderByIdDesc(VideoQuiz videoQuiz);
}
