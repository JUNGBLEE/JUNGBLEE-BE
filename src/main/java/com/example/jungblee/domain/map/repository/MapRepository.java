package com.example.jungblee.domain.map.repository;

import com.example.jungblee.domain.map.entity.Map;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface MapRepository extends JpaRepository<Map, Long> {
    @Query(value = "SELECT *, (6371 * acos(cos(radians(:x)) * cos(radians(u.latitude)) * cos(radians(u.longitude) - radians(:y)) + sin(radians(:x)) * sin(radians(u.latitude)))) AS distance FROM tbl_user AS u HAVING distance <= 5 ORDER BY distance;", nativeQuery = true)
    List<Map> findAllMap(@Param(value = "x") Double x, @Param(value = "y") Double y);
}
