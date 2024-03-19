package com.javaweb.api.admin;

import com.javaweb.converter.AssignmentBuildingConvert;
import com.javaweb.converter.BuildingEntityConvert;
import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.repository.AssignmentBuildingRepository;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "buildingAPIOfAdmin")
@RequestMapping("/api/building")
@Transactional
public class BuildingAPI {
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private RentAreaRepository rentAreaRepository;
    @Autowired
    private AssignmentBuildingRepository assignmentBuildingRepository;
    @Autowired
    private BuildingEntityConvert buildingEntityConvert;
    @Autowired
    private AssignmentBuildingConvert assignmentBuildingConvert;

    @PostMapping
    public void addOrUpdateBuilding(@RequestBody BuildingDTO buildingDTO) {

        BuildingEntity building = buildingEntityConvert.toBuildingEntity(buildingDTO);
        buildingRepository.save(building);
    }


    @DeleteMapping("/{ids}")
    public void deleteBuilding(@PathVariable List<Long> ids) {

        assignmentBuildingRepository.deleteByBuildingEntityIdIn(ids);
        rentAreaRepository.deleteByBuildingIdIn(ids);
        buildingRepository.deleteByIdIn(ids);

        System.out.println("ok");
    }

    @GetMapping("/{ids}/staffs")
    public ResponseDTO loadStaffs(@PathVariable Long ids) {
        ResponseDTO result = buildingService.listStaffs(ids);
        return result;
    }

    @PostMapping("/assignment")
    public void updateAssignmentBuilding(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO) {
        assignmentBuildingRepository.deleteByBuildingEntityId(assignmentBuildingDTO.getBuildingId());
        List<AssignmentBuildingEntity> rs = assignmentBuildingConvert.toAssignmentBuildingEntity(assignmentBuildingDTO);
        for (AssignmentBuildingEntity it : rs) {
            assignmentBuildingRepository.save(it);
        }
        System.out.println("ok");

    }
}
