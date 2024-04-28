package com.javaweb.service;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.dto.*;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.ResponseDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> listCustomers(CustomerDTO customerDTO, Pageable pageable);

    ResponseDTO listStaffs(Long customerId);

    int countTotalItems(CustomerDTO customerDTO);

    void updateAssignmentCustomer(AssignmentCustomerDTO assignmentBuildingDTO);


    void deleteCustomer(List<Long> ids);

    void addOrUpdateCustomer(CustomerDTO customerDTO);

    CustomerDTO customer(Long id);

    List<CustomerSearchRequest> result(CustomerDTO customerDTO);


}
