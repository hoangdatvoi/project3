package com.javaweb.service.impl;

import com.javaweb.converter.*;
import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.AssignmentBuildingRepository;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.BuildingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AssignmentBuildingRepository assignmentBuildingRepository;
    @Autowired
    private BuildingResponseConverter buildingResponseConverter;
    @Autowired
    private RentAreaRepository rentAreaRepository;
    @Autowired
    private BuildingEntityConvert buildingEntityConvert;
    @Autowired
    private AssignmentBuildingConvert assignmentBuildingConvert;
    @Autowired
    private RentAreaConvert rentAreaConvert;
    @Autowired
    private BuildingDTOConvert buildingDTOConvert;


    @Override
    public ResponseDTO listStaffs(Long buildingId) {
        BuildingEntity building = buildingRepository.findById(buildingId).get();
        List<UserEntity> staffs = userRepository.findByStatusAndRoles_Code(1, "STAFF");
        List<AssignmentBuildingEntity> assignmentBuildingEntities = assignmentBuildingRepository.findByBuildingEntityId(buildingId);
        List<UserEntity> staffAssignment = new ArrayList<>();
        for (AssignmentBuildingEntity item : assignmentBuildingEntities) {
            staffAssignment.add(item.getUserEntity());
        }
        List<StaffResponseDTO> staffResponseDTOS = new ArrayList<>();
        ResponseDTO responseDTO = new ResponseDTO();
        for (UserEntity it : staffs) {
            StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
            staffResponseDTO.setFullName(it.getFullName());
            staffResponseDTO.setStaffId(it.getId());
            if (staffAssignment.contains(it)) {
                staffResponseDTO.setChecked("checked");
            } else {
                staffResponseDTO.setChecked("");
            }
            staffResponseDTOS.add(staffResponseDTO);
        }
        responseDTO.setData(staffResponseDTOS);
        responseDTO.setMessage("success");
        return responseDTO;


    }

    @Override
    public List<BuildingSearchResponse> buildingList(BuildingSearchRequest buildingSearchRequest) {
        List<BuildingEntity> buildingEntities = buildingRepository.buildingEntities(buildingSearchRequest);
        List<BuildingSearchResponse> result = new ArrayList<>();
        for (BuildingEntity item : buildingEntities) {
            BuildingSearchResponse rs = buildingResponseConverter.toBuildingResponse(item);
            result.add(rs);

        }
        return result;
    }

    @Override
    public void addOrUpdateBuilding(BuildingDTO buildingDTO) {
        BuildingEntity building = buildingEntityConvert.toBuildingEntity(buildingDTO);
        List<RentAreaEntity> rentArea = rentAreaConvert.toRentAreaEntity(buildingDTO);
        buildingRepository.save(building);
        if (building.getId() != 0) {
            rentAreaRepository.deleteByBuildingId(building.getId());
        }
        for (RentAreaEntity it : rentArea) {
            it.setBuilding(building);

            rentAreaRepository.save(it);
        }


    }

    @Override
    public void deleteBuilding(List<Long> ids) {
        assignmentBuildingRepository.deleteByBuildingEntityIdIn(ids);
        rentAreaRepository.deleteByBuildingIdIn(ids);
        buildingRepository.deleteByIdIn(ids);
    }


    @Override
    public void updateAssignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO) {
        assignmentBuildingRepository.deleteByBuildingEntityId(assignmentBuildingDTO.getBuildingId());
        List<AssignmentBuildingEntity> rs = assignmentBuildingConvert.toAssignmentBuildingEntity(assignmentBuildingDTO);
        for (AssignmentBuildingEntity it : rs) {
            assignmentBuildingRepository.save(it);
        }
    }

    @Override
    public BuildingDTO getBuildingDTO(Long id) {
        BuildingEntity building = buildingRepository.findById(id).get();
        BuildingDTO rs = new BuildingDTO();
        List<RentAreaEntity> rentArea = rentAreaRepository.findByBuildingId(id);
        String value = "";
        for (RentAreaEntity it : rentArea) {
            value += Long.toString(it.getValue()) + ",";
        }
        if (!value.isEmpty()) {
            value = value.substring(0, value.length() - 1);
        }

        rs = buildingDTOConvert.tobuildingDTO(building);
        rs.setRentArea(value);
        return rs;

    }


}