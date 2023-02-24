package com.example.myhotel.models.repos;


import org.springframework.data.jpa.repository.JpaRepository;


import com.example.myhotel.models.entity.KindsRooms;

public interface KindRoomsHotelRepo extends JpaRepository<KindsRooms, Long> {
   
}
