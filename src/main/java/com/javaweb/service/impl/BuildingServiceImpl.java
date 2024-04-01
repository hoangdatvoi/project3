package com.javaweb.service.impl;

import com.javaweb.converter.*;
/*import com.javaweb.entity.AssignmentBuildingEntity;*/
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
/*import com.javaweb.repository.AssignmentBuildingRepository;*/
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.BuildingService;
import com.javaweb.utils.UploadFileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private UserRepository userRepository;
    /* @Autowired
     private AssignmentBuildingRepository assignmentBuildingRepository;*/
    @Autowired
    private BuildingResponseConverter buildingResponseConverter;
    @Autowired
    private RentAreaRepository rentAreaRepository;
    @Autowired
    private BuildingEntityConvert buildingEntityConvert;
    @Autowired
    private UploadFileUtils uploadFileUtils;
    /*
        @Autowired
        private AssignmentBuildingConvert assignmentBuildingConvert;
    */
    @Autowired
    private RentAreaConvert rentAreaConvert;
    @Autowired
    private BuildingDTOConvert buildingDTOConvert;

    @Transactional

    @Override
    public ResponseDTO listStaffs(Long buildingId) {
        BuildingEntity building = buildingRepository.findById(buildingId).get();
        List<UserEntity> staffs = userRepository.findByStatusAndRoles_Code(1, "STAFF");
        List<UserEntity> staffsassignment = building.getUserEntities();
        List<StaffResponseDTO> staffResponseDTOS = new ArrayList<>();
        ResponseDTO responseDTO = new ResponseDTO();
        for (UserEntity it : staffs) {
            StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
            staffResponseDTO.setFullName(it.getFullName());
            staffResponseDTO.setStaffId(it.getId());
            if (staffsassignment.contains(it)) {
                staffResponseDTO.setChecked("checked");

            } else {
                staffResponseDTO.setChecked("");
            }
            staffResponseDTOS.add(staffResponseDTO);
        }
        responseDTO.setData(staffResponseDTOS);
        return responseDTO;


    }

    @Override
    public List<BuildingSearchResponse> buildingList(BuildingSearchRequest buildingSearchRequest, Pageable pageable) {
        List<BuildingEntity> buildingEntities = buildingRepository.buildingEntities(buildingSearchRequest, pageable);
        List<BuildingSearchResponse> result = new ArrayList<>();
        for (BuildingEntity item : buildingEntities) {
            BuildingSearchResponse rs = buildingResponseConverter.toBuildingResponse(item);
            result.add(rs);

        }
        return result;
    }

    public void addOrUpdateBuilding(BuildingDTO buildingDTO) {
        BuildingEntity building = buildingEntityConvert.toBuildingEntity(buildingDTO);
        Long buildingId = buildingDTO.getId();
        if (buildingId != null) {
            BuildingEntity foundBuilding = buildingRepository.findById(buildingId)
                    .orElseThrow(() -> new NotFoundException("Building not found"));
            building.setImage(foundBuilding.getImage());
            building.setUserEntities(foundBuilding.getUserEntities());
        }

        saveThumbnail(buildingDTO, building);
        buildingRepository.save(building);
    }

    @Override
    public void deleteBuilding(List<Long> ids) {
        buildingRepository.deleteByIdIn(ids);
    }


    @Override
    public void updateAssignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO) {
        BuildingEntity building = buildingRepository.findById(assignmentBuildingDTO.getBuildingId()).get();
        List<UserEntity> userEntities = userRepository.findByIdIn(assignmentBuildingDTO.getStaffs());
        if (building != null) {
            building.getUserEntities().clear();
            building.setUserEntities(userEntities);
            buildingRepository.save(building);

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

    @Override
    public int countTotalItems() {
        return buildingRepository.countTotalItem();
    }

    @Override
    public List<BuildingSearchResponse> getAllBuildings(Pageable pageable) {
        List<BuildingEntity> buildingEntities = buildingRepository.getAllBuildings(pageable);
        List<BuildingSearchResponse> result = new ArrayList<>();
        for (BuildingEntity item : buildingEntities) {
            BuildingSearchResponse rs = buildingResponseConverter.toBuildingResponse(item);
            result.add(rs);

        }
        return result;
    }


    private void saveThumbnail(BuildingDTO buildingDTO, BuildingEntity buildingEntity) {
        String path = "/building/" + buildingDTO.getImageName();
        if (null != buildingDTO.getImageBase64()) {
            if (null != buildingEntity.getImage()) {
                if (!path.equals(buildingEntity.getImage())) {
                    File file = new File("C://home/office" + buildingEntity.getImage());
                    file.delete();
                }
            }
            byte[] bytes = Base64.decodeBase64(buildingDTO.getImageBase64().getBytes());
            UploadFileUtils uploadFileUtils1 = new UploadFileUtils();
            uploadFileUtils1.writeOrUpdate(path, bytes);
            buildingEntity.setImage(path);
        }
    }


}