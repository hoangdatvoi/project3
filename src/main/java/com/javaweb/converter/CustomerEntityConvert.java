package com.javaweb.converter;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.dto.CustomerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityConvert {
    @Autowired
    private ModelMapper modelMapper;

    public CustomerEntity toCustomerEntity(CustomerDTO item) {
        CustomerEntity rs = modelMapper.map(item, CustomerEntity.class);
        rs.setIs_active(1);
        rs.setFullName(item.getFullname());
        rs.setStatus("chưa xử lý");
        return rs;

    }
}
