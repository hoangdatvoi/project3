package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BuildingDTOConvert {
    @Autowired
    private ModelMapper modelMapper;

    public BuildingDTO tobuildingDTO(BuildingEntity item) {
        BuildingDTO rs = modelMapper.map(item, BuildingDTO.class);
        List<String> list = Arrays.asList(item.getType().split(","));
        rs.setTypeCode(list);


        return rs;

    }
}
