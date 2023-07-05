package com.example.jungblee.domain.map.controller;

import com.example.jungblee.domain.map.controller.dto.request.MapRequest;
import com.example.jungblee.domain.map.controller.dto.response.MapListResponse;
import com.example.jungblee.domain.map.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/map")
@RestController
public class MapController {

    private final MapService mapService;

    @GetMapping
    public MapListResponse mapList(
            @RequestBody MapRequest request
    ) {
        return mapService.findMapList(request);
    }
}
