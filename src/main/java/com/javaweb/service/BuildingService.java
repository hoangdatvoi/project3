package com.javaweb.service;

import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BuildingService {
    ResponseDTO listStaffs(Long buildingId);

    List<BuildingSearchResponse> buildingList(BuildingSearchRequest buildingSearchRequest);
}
