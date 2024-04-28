package com.javaweb.utils;

import com.javaweb.model.dto.CustomerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConvertUtil {
    @Autowired
    private ModelMapper modelMapper;

    public CustomerDTO dto(CustomerDTO customerDTO) {
        CustomerDTO customerDTO1 = modelMapper.map(customerDTO, CustomerDTO.class);
        List<CustomerDTO> customerDTOList = customerDTO.getListResult();
        for (CustomerDTO dto : customerDTOList) {
            if (dto.getListResult().equals("CXL")) {
                customerDTO1.setStatus("chưa xử lý");
            } else if (customerDTO.getStatus().equals("XL")) {
                customerDTO1.getStatus().equals("đã xử lý");
            } else {
                customerDTO1.getStatus().equals("đang xử lý");
            }

        }

        return customerDTO1;
    }
}
