package com.javaweb.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.response.BuildingSearchResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BuildingResponseConverter {

    @Autowired
    private ModelMapper modelMapper;

    public BuildingSearchResponse toBuildingResponse(BuildingEntity items) {
        BuildingSearchResponse rs = modelMapper.map(items, BuildingSearchResponse.class);
        //String districtName = districtRepository.findDistrictNameByDistrictId(items.getDistrictid());
        rs.setAddress(items.getStreet() + "," + items.getWard() + "," + items.getDistrict());
        List<RentAreaEntity> rentAreas = items.getItems();
        String areaResult = rentAreas.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
        rs.setRentArea(areaResult);
        return rs;

    }

}
