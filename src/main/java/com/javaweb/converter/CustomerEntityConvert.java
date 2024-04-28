package com.javaweb.converter;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.enums.DistrictCode;
import com.javaweb.enums.StatusType;
import com.javaweb.model.dto.CustomerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;

@Component
public class CustomerEntityConvert {
    @Autowired
    private ModelMapper modelMapper;

    public CustomerEntity toCustomerEntity(CustomerDTO item) {
        CustomerEntity rs = modelMapper.map(item, CustomerEntity.class);
        rs.setIs_active(1);
        rs.setFullName(item.getFullname());
        if (item.getId() != 0) {
            Map<String, String> mp = new TreeMap<>();
            mp = StatusType.type();
            String status = "";
            for (Map.Entry<String, String> entry : mp.entrySet()) {

                if (entry.getKey().equals(item.getStatus())) {
                    status += entry.getValue();
                }

            }
            rs.setStatus(status);
        } else {
            rs.setStatus("chưa xử lý");
        }

        return rs;

    }
}
