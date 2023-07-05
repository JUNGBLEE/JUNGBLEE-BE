package com.example.jungblee.domain.videoquiz.repository;

import com.example.jungblee.domain.videoquiz.entity.VideoQuiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoQuizRepository extends JpaRepository<VideoQuiz, Long> {
}
