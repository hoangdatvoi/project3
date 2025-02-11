package com.javaweb.repository;

import com.javaweb.entity.RentAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentAreaRepository extends JpaRepository<RentAreaEntity, Long> {
    void deleteByBuildingIdIn(List<Long> ids);

    List<RentAreaEntity> findByBuildingId(Long buildingId);

    void deleteByBuildingId(Long id);
}