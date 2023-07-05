package com.example.jungblee.domain.user.controller;

import com.example.jungblee.domain.auth.controller.dto.response.TokenResponse;
import com.example.jungblee.domain.user.controller.dto.request.LoginRequest;
import com.example.jungblee.domain.user.controller.dto.request.SignupRequest;
import com.example.jungblee.domain.user.controller.dto.response.UserResponse;
import com.example.jungblee.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public void signup(
            @RequestBody @Valid SignupRequest request
    ) {
        userService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse login(
            @RequestBody LoginRequest request
    ) {
        return userService.login(request);
    }

    @GetMapping("/mypage")
    public UserResponse myPage() {
        return userService.myPage();
    }
}
