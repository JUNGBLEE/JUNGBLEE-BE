package com.example.jungblee.domain.quiz.repository;

import com.example.jungblee.domain.quiz.entity.Quiz;
import com.example.jungblee.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Optional<Quiz> findAllByUser(User user);

    List<Quiz> findAllByUserAndSuccessful(User user, boolean successful);
}
