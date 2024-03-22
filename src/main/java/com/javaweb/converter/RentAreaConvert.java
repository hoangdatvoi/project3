package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.dto.BuildingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RentAreaConvert {
    @Autowired
    BuildingEntityConvert buildingEntityConvert;

    public List<RentAreaEntity> toRentAreaEntity(BuildingDTO buildingDTO) {
        BuildingEntity building = buildingEntityConvert.toBuildingEntity(buildingDTO);
        List<RentAreaEntity> rs = new ArrayList<>();
        String[] numberArray = buildingDTO.getRentArea().split(",");

        for (String it : numberArray) {
            RentAreaEntity rentArea = new RentAreaEntity();
            rentArea.setBuilding(building);
            rentArea.setValue(Long.parseLong(it));
            rs.add(rentArea);

        }

        return rs;
    }
}