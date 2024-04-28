package com.javaweb.service;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.dto.UserDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BuildingService {
    ResponseDTO listStaffs(Long buildingId);

    List<BuildingSearchResponse> buildingList(BuildingSearchRequest buildingSearchRequest, Pageable pageable);

    void addOrUpdateBuilding(BuildingDTO buildingDTO);

    void deleteBuilding(List<Long> ids);


    void updateAssignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO);

    BuildingDTO getBuildingDTO(Long id);

    int countTotalItems(BuildingSearchRequest buildingSearchRequest);

    List<BuildingSearchResponse> getAllBuildings(Pageable pageable);


}