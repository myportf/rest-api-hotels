package com.example.myhotel.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myhotel.models.entity.KindsRooms;
import com.example.myhotel.models.repos.KindRoomsHotelRepo;

@Service
public class KindRoomHotelService {

    @Autowired
    KindRoomsHotelRepo kindRoomsHotelRepo;

    public Iterable<KindsRooms> findAll(){
        return kindRoomsHotelRepo.findAll();
    } 

    public Optional<KindsRooms> findById(Long id){
        return kindRoomsHotelRepo.findById(id);
    }
}
