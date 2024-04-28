package com.javaweb.service.impl;

import com.javaweb.converter.CustomerDTOConvert;
import com.javaweb.converter.CustomerEntityConvert;
import com.javaweb.converter.CustomerReponse;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentCustomerDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerDTOConvert customerDTOConvert;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomerEntityConvert customerEntityConvert;
    @Autowired
    private CustomerReponse customerReponse;

    @Override
    public List<CustomerDTO> listCustomers(CustomerDTO customerDTO, Pageable pageable) {
        List<CustomerEntity> customerEntities = customerRepository.customerEntities(customerDTO, pageable);
        List<CustomerDTO> result = new ArrayList<>();
        for (CustomerEntity it : customerEntities) {
            CustomerDTO customerDTO1 = new CustomerDTO();
            customerDTO1 = customerDTOConvert.tobuildingDTO1(it);
            result.add(customerDTO1);
        }
        return result;
    }

    @Override
    public ResponseDTO listStaffs(Long customerId) {
        CustomerEntity customer = customerRepository.findById(customerId).get();
        List<UserEntity> staffs = userRepository.findByStatusAndRoles_Code(1, "STAFF");
        List<UserEntity> staffsassignment = customer.getUsers();
        List<StaffResponseDTO> staffResponseDTOS = new ArrayList<>();
        ResponseDTO responseDTO = new ResponseDTO();
        for (UserEntity it : staffs) {
            StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
            staffResponseDTO.setFullName(it.getFullName());
            staffResponseDTO.setStaffId(it.getId());
            if (staffsassignment.contains(it)) {
                staffResponseDTO.setChecked("checked");

            } else {
                staffResponseDTO.setChecked("");
            }
            staffResponseDTOS.add(staffResponseDTO);
        }
        responseDTO.setData(staffResponseDTOS);
        return responseDTO;


    }

    public int countTotalItems(CustomerDTO customerDTO) {
        return customerRepository.countTotalItem(customerDTO);
    }

    @Override
    public void updateAssignmentCustomer(AssignmentCustomerDTO assignmentCustomerDTO) {
        CustomerEntity customer = customerRepository.findById(assignmentCustomerDTO.getCustomerId()).get();
        List<UserEntity> userEntities = userRepository.findByIdIn(assignmentCustomerDTO.getStaffs());
        if (customer != null) {
            customer.getUsers().clear();
            customer.setUsers(userEntities);
            customerRepository.save(customer);

        }

    }


    @Override
    public void deleteCustomer(List<Long> ids) {
        List<CustomerEntity> customerEntities = customerRepository.findByIdIn(ids);
        for (CustomerEntity it : customerEntities) {
            it.setIs_active(0);
            customerRepository.save(it);
        }
    }

    @Override
    public void addOrUpdateCustomer(CustomerDTO customerDTO) {
        CustomerEntity customer = customerEntityConvert.toCustomerEntity(customerDTO);
        System.out.println(customer);


        customerRepository.save(customer);
        System.out.println("ssss");

    }

    @Override
    public CustomerDTO customer(Long id) {
        CustomerEntity customerEntity = customerRepository.findById(id).get();
        CustomerDTO result = customerDTOConvert.tobuildingDTO(customerEntity);
        return result;
    }

    @Override
    public List<CustomerSearchRequest> result(CustomerDTO customerDTO) {
        List<CustomerEntity> customerEntities1 = customerRepository.customerEntities1(customerDTO);
        List<CustomerSearchRequest> rs = new ArrayList<>();
        for (CustomerEntity customer : customerEntities1) {
            CustomerSearchRequest customerSearchRequest = customerReponse.reponse(customer);
            rs.add(customerSearchRequest);

        }
        return rs;
    }
}
