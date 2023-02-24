package com.example.myhotel.models.repos;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.example.myhotel.DTO.RoomHotelsData;
import com.example.myhotel.models.entity.RoomHotels;

public interface RoomHotelsRepo extends JpaRepository<RoomHotels, Long> {
    @Procedure("gettariffactiverooms")
    Double getTariffActiveCurr(Long roomhotels_id);

    @Procedure("getactivetariffbydate")
    Double getactivetariffroombydate(Long roomhotels_id,String _datebook);
    
    // list room hotel
    @Query(nativeQuery = true, value="SELECT c.* from vw_room_list_hotels c")
    List<RoomHotelsData> getlistofRoomHotel();

     // list room hotel by kind name room
     @Query(nativeQuery = true, value="SELECT c.* from vw_room_list_hotels c where c.kind_room like :kindsRooms")
     List<RoomHotelsData> getlistofRoomHotelByKindName(@PathParam("kindsRooms") String kindsRooms);

    // @Query("SELECT p FROM RoomHotels p WHERE :kindsRooms MEMBER OF p.kindsRooms ")
    // public List <RoomHotels> finProductByKindRooms(@PathParam("kindsRooms") KindsRooms kindsRooms);
}
