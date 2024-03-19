package com.javaweb.converter;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.enums.DistrictCode;
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
        Map<String, String> mp = new TreeMap<>();
        mp = DistrictCode.type();
        String district = "";
        for (Map.Entry<String, String> entry : mp.entrySet()) {

            if (entry.getKey().equals(items.getDistrict())) {
                district += entry.getValue();
            }

        }
        rs.setAddress(items.getStreet() + "," + items.getWard() + "," + district);
        List<RentAreaEntity> rentAreas = items.getItems();
        String areaResult = rentAreas.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
        rs.setRentArea(areaResult);
        return rs;

    }

}
