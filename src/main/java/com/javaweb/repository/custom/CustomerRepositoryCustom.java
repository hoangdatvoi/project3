package com.javaweb.repository.custom;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.dto.CustomerDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerRepositoryCustom {
    List<CustomerEntity> customerEntities(CustomerDTO customerDTO, Pageable pageable);

    List<CustomerEntity> customerEntities1(CustomerDTO customerDTO);

    int countTotalItem(CustomerDTO customerDTO);

}
