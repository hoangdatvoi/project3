package com.javaweb.converter;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.CustomerSearchRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerReponse {
    @Autowired
    private ModelMapper modelMapper;

    public CustomerSearchRequest reponse(CustomerEntity item) {
        CustomerSearchRequest rs = modelMapper.map(item, CustomerSearchRequest.class);
        return rs;
    }

}
