package com.javaweb.controller.admin;


import com.javaweb.enums.BuildingType;
import com.javaweb.enums.DistrictCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller(value = "buildingControllerOfAdmin")
public class BuildingController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/admin/building-list")
    public ModelAndView buildingList(@ModelAttribute BuildingSearchRequest buildingSearchRequest, HttpServletRequest request) {
        ModelAndView mvc = new ModelAndView("admin/building/list");
        mvc.addObject("modelSearch", buildingSearchRequest);
        mvc.addObject("listStaffs", userService.getStaffs());
        mvc.addObject("districts", DistrictCode.type());
        mvc.addObject("typeCodes", BuildingType.type());
        return mvc;
    }

    @GetMapping(value = "/admin/building-edit")
    public ModelAndView buildingEdit(@ModelAttribute("buildingEdit") BuildingDTO buildingDTO, HttpServletRequest request) {
        ModelAndView mvc = new ModelAndView("admin/building/edit");
        mvc.addObject("districts", DistrictCode.type());
        mvc.addObject("typeCodes", BuildingType.type());
        return mvc;
    }

    @GetMapping(value = "/admin/building-edit-{id}")
    public ModelAndView buildingEdit(@PathVariable("id") Long id, HttpServletRequest request) {
        ModelAndView mvc = new ModelAndView("admin/building/edit");
        mvc.addObject("districts", DistrictCode.type());
        mvc.addObject("typeCodes", BuildingType.type());

        return mvc;
    }


}
