package com.example.jungblee.domain.map.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MapListResponse {

    private List<MapResponse> mapResponseList;
}
