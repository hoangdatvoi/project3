/*
package com.javaweb.converter;

*/
/*import com.javaweb.entity.AssignmentBuildingEntity;*//*

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AssignmentBuildingConvert {
    @Autowired
    private ModelMapper modelMapper;

    public List<AssignmentBuildingEntity> toAssignmentBuildingEntity(AssignmentBuildingDTO item) {
        List<AssignmentBuildingEntity> rs = new ArrayList<>();
        BuildingEntity buildingEntity = new BuildingEntity();
        buildingEntity.setId(item.getBuildingId());

        for (Long staffId : item.getStaffs()) {
            AssignmentBuildingEntity assignmentBuildingEntity = new AssignmentBuildingEntity();
            assignmentBuildingEntity.setBuildingEntity(buildingEntity);

            UserEntity userEntity = new UserEntity();
            userEntity.setId(staffId);
            assignmentBuildingEntity.setUserEntity(userEntity);

            rs.add(assignmentBuildingEntity);
        }

        return rs;
    }
}
*/
