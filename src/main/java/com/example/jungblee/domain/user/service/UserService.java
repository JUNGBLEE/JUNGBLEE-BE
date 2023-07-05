package com.example.jungblee.domain.user.service;

import com.example.jungblee.domain.auth.controller.dto.response.TokenResponse;
import com.example.jungblee.domain.quiz.repository.QuizRepository;
import com.example.jungblee.domain.user.controller.dto.request.LoginRequest;
import com.example.jungblee.domain.user.controller.dto.request.SignupRequest;
import com.example.jungblee.domain.user.controller.dto.response.UserResponse;
import com.example.jungblee.domain.user.entity.User;
import com.example.jungblee.domain.user.repository.UserRepository;
import com.example.jungblee.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final QuizRepository quizRepository;

    private final UserRepository userRepository;

    private final UserFacade userFacade;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public void
    signup(SignupRequest request) {

        if (userRepository.existsByAccountId(request.getAccountId()))
            throw new RuntimeException();

        userRepository.save(
                User.builder()
                        .username(request.getUsername())
                        .accountId(request.getAccountId())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .build()
        );
    }


    @Transactional
    public TokenResponse login(LoginRequest loginRequest) {

        User user = userRepository.findByAccountId(loginRequest.getAccountId())
                .orElseThrow(() -> new RuntimeException());

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
            throw new RuntimeException();

        String access = jwtTokenProvider.generateAccessToken(loginRequest.getAccountId());

        return new TokenResponse(access);
    }

    @Transactional(readOnly = true)
    public UserResponse myPage() {

        User user = userFacade.currentUser();

        return UserResponse.builder()
                .username(user.getUsername())
                .accountId(user.getAccountId())
                .successQuizCount(quizRepository.findAllByUserAndSuccessfulOrderByIdDesc(user, true).size())
                .failedQuizCount(quizRepository.findAllByUserAndSuccessfulOrderByIdDesc(user, false).size())
                .build();
    }
}
