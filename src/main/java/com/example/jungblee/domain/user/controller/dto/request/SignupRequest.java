package com.example.jungblee.domain.user.controller.dto.request;

import lombok.*;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class SignupRequest {

    @Size(min = 2, max = 10, message = "이름은 2글자에서 10글자 사이여야합니다." )
    private String username;

    @Size(min = 5, max = 20, message = "아이디는 5글자에서 20글자 사이여야합니다.")
    private String accountId;

    @Pattern(regexp = "^(?=.*[!@#$%^&*])(?=.{5,30}$).*",
            message = "비밀번호는 5글자에서 30글자 사이여야하며, 특수문자가 한 개 이상 포함되어야합니다.")
    private String password;
}
