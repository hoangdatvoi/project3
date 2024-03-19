package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.dto.BuildingDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuildingEntityConvert {
    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    public BuildingEntityConvert(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

        PropertyMap<BuildingDTO, BuildingEntity> propertyMap = new PropertyMap<BuildingDTO, BuildingEntity>() {
            protected void configure() {
                map().setRentprice(source.getRentPrice());
            }
        };

        modelMapper.addMappings(propertyMap);
    }

    public BuildingEntity toBuildingEntity(BuildingDTO item) {
        BuildingEntity rs = modelMapper.map(item, BuildingEntity.class);
        List<String> typeCode = item.getTypeCode();
        String convert = String.join(",", typeCode);
        rs.setType(convert);
        return rs;
    }
}
