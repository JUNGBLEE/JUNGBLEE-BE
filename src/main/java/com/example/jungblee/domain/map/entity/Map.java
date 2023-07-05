package com.example.jungblee.domain.map.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "tbl_map")
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "map_id")
    private Long id;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "casualties")
    private int casualties;

    @Column(name = "type")
    private String type;

    @Column(name = "attacker_age")
    private int attackerAge;

    @Column(name = "victim_age")
    private int victimAge;
}
