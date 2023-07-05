package com.example.jungblee.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // 404 Not found
    USER_NOT_FOUND(404, "user not found"),
    BOARD_NOT_FOUND(404, "board not found"),

    // 409 Conflict
    USER_ALREADY_EXISTS(409, "user already exists");

    private final int statusCode;

    private final String message;
}
