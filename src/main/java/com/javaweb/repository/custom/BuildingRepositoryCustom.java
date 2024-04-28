package com.javaweb.repository.custom;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BuildingRepositoryCustom {
    List<BuildingEntity> buildingEntities(BuildingSearchRequest buildingSearchRequest, Pageable pageable);

    List<BuildingEntity> getAllBuildings(Pageable pageable);

    int countTotalItem(BuildingSearchRequest buildingSearchRequest);
}
