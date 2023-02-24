package com.example.myhotel.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myhotel.DTO.RoomHotelsData;
import com.example.myhotel.models.entity.RoomHotels;
import com.example.myhotel.services.RoomHotelsService;

@RestController
@RequestMapping("/api/roomshotels")
public class RoomControllers {

    @Autowired
    RoomHotelsService roomHotelsService;
    
    //find all room 
    @GetMapping
    public Iterable<RoomHotels> findAllRooms(){
        return roomHotelsService.findAllRoom();
    }

    //find detail per room hotel
    @GetMapping("/{id}")
    public Optional<RoomHotels> findById(@PathVariable("id") Long roomid){
        return roomHotelsService.findById(roomid);
    }

    @GetMapping("/curractive/{id}")
    public Double getcurrtariffactive(@PathVariable("id") Long id){
        return roomHotelsService.getCurrentTariffRoom(id);
    }

    @GetMapping("/curractivebydatebook/{id}/{datebook}")
    public Double getcurrtariffactive(@PathVariable("id") Long id, @PathVariable("datebook") String datebook){
        return roomHotelsService.getCurrTariffByBookDate(id, datebook);
    }

    @GetMapping("/previewlistroomhotels")
    public List<RoomHotelsData> showlistroomhotels(){
        return roomHotelsService.getListRoomHotels();
    }

    @GetMapping("exploreroomshotelsbykindroom/{kindroomname}")
    public List<RoomHotelsData> showListRoomHotelByKindName(@PathVariable("kindroomname") String kindnamekey){
        return roomHotelsService.getListRoomHotelsByKindName(kindnamekey);
    }

}
