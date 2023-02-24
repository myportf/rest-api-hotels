package com.example.myhotel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myhotel.DTO.HotelData;
import com.example.myhotel.DTO.ResponsData;
import com.example.myhotel.models.entity.AccomodationPolicies;
// import com.example.myhotel.models.entity.AccomodationPolicies;
import com.example.myhotel.models.entity.Hotels;
import com.example.myhotel.services.HotelService;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Iterable<Hotels> findAll(){
        return hotelService.findAll();
    }

    @PostMapping("/savehotel")
    public ResponseEntity <ResponsData<Hotels>> reqister(@RequestBody HotelData hotelData){
        ResponsData<Hotels> responsData = new ResponsData<>();
        Hotels hotels = modelMapper.map(hotelData, Hotels.class);
        responsData.setPayload(hotelService.savehotels(hotels));
        responsData.setStatus(true);
        responsData.getMessage().add("Data Saved!");
        return ResponseEntity.ok(responsData);
    }
    
    /*
        Accomodation Policies are like rule of the hotels related with time check in - check out ,
        Info related required Document e.t.c
    */
    @PostMapping("/addaccomodationpolicies/{id}")
    public ResponseEntity <ResponsData<AccomodationPolicies>> addAccomodationPolicies(@RequestBody AccomodationPolicies accomodationPolicies, @PathVariable("id") Long id){
        ResponsData<AccomodationPolicies> responsData = new ResponsData<>();
        //Add Accoomodation policies
        hotelService.addAccomodationpolicies(accomodationPolicies, id);
        responsData.setPayload(accomodationPolicies);
        responsData.setStatus(true);
        responsData.getMessage().add("Data Saved!");
        return ResponseEntity.ok(responsData);
    }

    @DeleteMapping("{id}")
    public void removeByid(@PathVariable("id") Long id){
        hotelService.removeone(id);
    }

}
