package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.dto.CustomerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CustomerDTOConvert {
    @Autowired
    private ModelMapper modelMapper;

    public CustomerDTO tobuildingDTO(CustomerEntity item) {
        CustomerDTO rs = modelMapper.map(item, CustomerDTO.class);
        if (item.getStatus().equals("chưa xử lý")) {
            rs.setStatus("CXL");
        } else if (item.getStatus().equals("đã xử lý")) {
            rs.setStatus("XL");
        } else {
            rs.setStatus("DXL");
        }
        return rs;

    }

    public CustomerDTO tobuildingDTO1(CustomerEntity item) {
        CustomerDTO rs = modelMapper.map(item, CustomerDTO.class);

        return rs;

    }
}
