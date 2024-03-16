package com.javaweb.controller.admin;


import com.javaweb.enums.BuildingType;
import com.javaweb.enums.DistrictCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.service.BuildingService;
import com.javaweb.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller(value = "buildingControllerOfAdmin")
public class BuildingController {
    @Autowired
    private UserService userService;
    @Autowired
    private BuildingService buildingService;

    @GetMapping(value = "/admin/building-list")
    public ModelAndView buildingList(@ModelAttribute BuildingSearchRequest buildingSearchRequest, HttpServletRequest request) {
        ModelAndView mvc = new ModelAndView("admin/building/list");

        List<BuildingSearchResponse> responses = buildingService.buildingList(buildingSearchRequest);
        mvc.addObject("buildingList", responses);
        mvc.addObject("modelSearch", buildingSearchRequest);
        mvc.addObject("listStaffs", userService.getStaffs());
        mvc.addObject("districts", DistrictCode.type());
        mvc.addObject("typeCodes", BuildingType.type());
        return mvc;
    }


    @GetMapping(value = "/admin/building-edit")
    public ModelAndView buildingEdit(@ModelAttribute("buildingEdit") BuildingSearchRequest buildingSearchRequest, HttpServletRequest request) {
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
