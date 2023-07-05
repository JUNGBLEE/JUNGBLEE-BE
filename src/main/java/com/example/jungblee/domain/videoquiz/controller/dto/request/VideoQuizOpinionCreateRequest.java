package com.example.jungblee.domain.videoquiz.controller.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VideoQuizOpinionCreateRequest {

    @Size(min = 1, max = 100, message = "의견은 1글자에서 100글자 사이여야합니다.")
    private String content;

    @NotNull(message = "의견을 작성하려면 진영을 선택해야합니다.")
    private boolean team;
}
