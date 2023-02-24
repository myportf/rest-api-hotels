package com.example.myhotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myhotel.models.entity.AccomodationPolicies;
import com.example.myhotel.models.entity.Hotels;
import com.example.myhotel.models.repos.HotelRepo;

@Service
public class HotelService {

    @Autowired
    HotelRepo hotelRepo;

    public List<Hotels> findAll(){
        return hotelRepo.findAll();
    }

    public Hotels savehotels(Hotels hotels){
        return hotelRepo.save(hotels);
    }

    public void addAccomodationpolicies(AccomodationPolicies accomodationPolicies, Long hotel_id){
        Hotels hotels = findbyId(hotel_id);
        if(hotels == null){
            throw new RuntimeException("Data with ID :" + hotel_id + "does not existist");
        }
        // product.getSupplier().add(supplier);
        hotels.getAccomodationPolicies().add(accomodationPolicies);
        savehotels(hotels);
    }

    public Hotels findbyId(Long id){
        Optional<Hotels> hotels = hotelRepo.findById(id);
        if(!hotels.isPresent()){
            return null;
        }
        return hotelRepo.findById(id).get();
    }

    public void removeone(Long id){
        hotelRepo.deleteById(id);
    }

}
