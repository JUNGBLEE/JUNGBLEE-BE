package com.example.jungblee.domain.map.controller.dto.response;

import com.example.jungblee.domain.map.entity.Map;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MapResponse {

    private Long id;

    private double latitude;

    private double longitude;

    private int casualties;

    private String type;

    private int attackerAge;

    private int victimAge;

    public static MapResponse of(
            Map map
    ) {

        return MapResponse.builder()
                .id(map.getId())
                .latitude(map.getLatitude())
                .longitude(map.getLongitude())
                .casualties(map.getCasualties())
                .type(map.getType())
                .attackerAge(map.getAttackerAge())
                .victimAge(map.getVictimAge())
                .build();
    }
}