package com.example.myhotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myhotel.DTO.RoomHotelsData;
import com.example.myhotel.models.entity.RoomHotels;
import com.example.myhotel.models.repos.RoomHotelsRepo;


@Service
public class RoomHotelsService {
    @Autowired
    RoomHotelsRepo roomHotelsRepo;

    // find all list room 
    public List<RoomHotels> findAllRoom(){
        return roomHotelsRepo.findAll();
    }

    public Optional<RoomHotels> findById(Long roomid){
        return roomHotelsRepo.findById(roomid);
    }

    public Double getCurrentTariffRoom(Long roomid){
        return roomHotelsRepo.getTariffActiveCurr(roomid);
    }

    public Double getCurrTariffByBookDate(Long roomid, String datebooked){
        return roomHotelsRepo.getactivetariffroombydate(roomid, datebooked);
    }

    public List<RoomHotelsData> getListRoomHotels(){
        return roomHotelsRepo.getlistofRoomHotel();
    }

    public List<RoomHotelsData> getListRoomHotelsByKindName(String kindnamekey){
        return roomHotelsRepo.getlistofRoomHotelByKindName('%' + kindnamekey +"%");
    }

}
