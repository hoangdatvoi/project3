package com.javaweb.controller.admin;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.enums.BuildingType;
import com.javaweb.enums.DistrictCode;
import com.javaweb.enums.StatusType;
import com.javaweb.enums.TransactionType;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.CustomerService;
import com.javaweb.service.TransactionService;
import com.javaweb.service.impl.UserService;
import com.javaweb.utils.DisplayTagUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "/admin/customer-list", method = RequestMethod.GET)
    public ModelAndView customerList(@ModelAttribute CustomerDTO customerDTO, HttpServletRequest request) {
        ModelAndView mvc = new ModelAndView("admin/customer/list");
        if (SecurityUtils.getAuthorities().contains("ROLE_STAFF")) {
            Long staffId = SecurityUtils.getPrincipal().getId();
            customerDTO.setStaffId(staffId);

        }
        DisplayTagUtils.of(request, customerDTO);
        List<CustomerDTO> customerDTOList = customerService.listCustomers(customerDTO, new PageRequest(customerDTO.getPage() - 1, customerDTO.getMaxPageItems()));
        customerDTO.setListResult(customerDTOList);
        customerDTO.setTotalItems(customerService.countTotalItems());
        mvc.addObject("listStaffs", userService.getStaffs());
        mvc.addObject("model", customerDTO);


        return mvc;
    }

    @GetMapping(value = "/admin/customer-edit")
    public ModelAndView buildingEdit(@ModelAttribute("customerEdit") CustomerDTO customerDTO, HttpServletRequest request) {
        ModelAndView mvc = new ModelAndView("admin/customer/edit");
        mvc.addObject("status", StatusType.type());
        mvc.addObject("transactionType", TransactionType.tracsactionType());
        return mvc;
    }

    @GetMapping(value = "/admin/customer-view")
    public ModelAndView buildingEdit2() {
        ModelAndView mvc = new ModelAndView("web/contact");

        return mvc;
    }

    @GetMapping(value = "/admin/customer-edit-{id}")
    public ModelAndView buildingEdit1(@PathVariable("id") Long id) {

        ModelAndView mvc = new ModelAndView("admin/customer/edit");
        mvc.addObject("customerEdit", customerService.customer(id));
        mvc.addObject("status", StatusType.type());
        mvc.addObject("transactionType", TransactionType.tracsactionType());
        mvc.addObject("transactionCSKH", transactionService.transactionCSKH("CSKH", id));
        mvc.addObject("transactionDDX", transactionService.transactionDDX("DDX", id));


        return mvc;
    }
}