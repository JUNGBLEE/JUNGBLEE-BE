package com.example.jungblee.domain.map.service;

import com.example.jungblee.domain.map.controller.dto.request.MapRequest;
import com.example.jungblee.domain.map.controller.dto.response.MapListResponse;
import com.example.jungblee.domain.map.controller.dto.response.MapResponse;
import com.example.jungblee.domain.map.entity.Map;
import com.example.jungblee.domain.map.repository.MapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MapService {

    private final MapRepository mapRepository;

    @Transactional(readOnly = true)
    public MapListResponse findMapList(
            MapRequest request
    ) {

        List<MapResponse> mapResponseList =
                mapRepository.findAllMap(request.getX(), request.getY())
                        .stream()
                        .map(MapResponse::of)
                        .toList();

        return new MapListResponse(mapResponseList);
    }
}