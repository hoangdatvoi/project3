package com.javaweb.service.impl;

import com.javaweb.converter.BuildingResponseConverter;
import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.AssignmentBuildingRepository;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
}
