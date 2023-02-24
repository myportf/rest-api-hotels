package com.example.myhotel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myhotel.DTO.AddonsFacilitiesData;
import com.example.myhotel.DTO.ResponsData;
import com.example.myhotel.models.entity.AddOnsFacilities;
import com.example.myhotel.services.AddonsFacilitiesService;

@RestController
@RequestMapping("/api/Addonsfacilities")
public class AddonsFacilitiesController {
    
    @Autowired
    AddonsFacilitiesService addonsFacilitiesService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Iterable<AddOnsFacilities> findAllFacilities(){
        return addonsFacilitiesService.findAllData();
    }

    @PostMapping("/saveaddonsfacilities")
    public ResponseEntity <ResponsData<AddOnsFacilities>> reqister(@RequestBody AddonsFacilitiesData hotelData){
        ResponsData<AddOnsFacilities> responsData = new ResponsData<>();
        AddOnsFacilities addOnsFacilities = modelMapper.map(hotelData, AddOnsFacilities.class);
        responsData.setPayload(addonsFacilitiesService.saveData(addOnsFacilities));
        responsData.setStatus(true);
        responsData.getMessage().add("Data Saved!");
        return ResponseEntity.ok(responsData);
    }

}
