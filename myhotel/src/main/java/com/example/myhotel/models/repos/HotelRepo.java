package com.example.myhotel.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myhotel.models.entity.Hotels;

public interface  HotelRepo extends JpaRepository<Hotels, Long> {
    
}
