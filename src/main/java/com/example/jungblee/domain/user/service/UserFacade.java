package com.example.jungblee.domain.user.service;

import com.example.jungblee.domain.user.entity.User;
import com.example.jungblee.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User currentUser() {

        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository.findByAccountId(accountId)
                .orElseThrow(() -> new RuntimeException()); // TODO: 2023-07-05
    }
}
