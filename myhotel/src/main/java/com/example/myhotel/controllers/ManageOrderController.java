package com.example.myhotel.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import javax.persistence.criteria.Order;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myhotel.DTO.OrdersData;
import com.example.myhotel.DTO.ResponsData;
import com.example.myhotel.models.entity.AppUser;
import com.example.myhotel.models.entity.Orders;
import com.example.myhotel.services.AppUserService;
import com.example.myhotel.services.OrdersService;

@RestController
@RequestMapping("/api/orders")
public class ManageOrderController {

    @Autowired
    AppUserService appUserService;

    @Autowired
    OrdersService ordersService;
    
    @Autowired
    ModelMapper modelMapper;

    //create order without sesion
    @PostMapping("/createorder/{username}")
    public ResponseEntity <ResponsData<Orders>> createOrder(@RequestBody OrdersData ordersData, @PathVariable("username") String username){
        ResponsData<Orders> responsData = new ResponsData<>();
        //check user | guest 
        AppUser appUser = appUserService.findUserByEmail(username).get();
        Orders orders = modelMapper.map(ordersData, Orders.class);
        orders.setAppUser(appUser);
        responsData.setPayload(ordersService.saveOrders(orders));
        responsData.setStatus(true);
        responsData.getMessage().add("Data Saved!");
        return ResponseEntity.ok(responsData);
    }

    @GetMapping("/checkin/{id}")
    public String checkinOrder(@PathVariable("id") Long id){
        Orders orders = ordersService.findById(id);
        //check from date 
        LocalDate datePart = orders.getFrom_date().toLocalDate();
        LocalTime timePart = LocalTime.parse("04:05:06");
        LocalDateTime dt = LocalDateTime.of(datePart, timePart);
        return "";
    }
    
}
