package com.example.myhotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myhotel.models.entity.OrderDetails;
import com.example.myhotel.models.repos.OrderDetailsRepo;

@Service
public class OrderDetailsService {
    
    @Autowired
    OrderDetailsRepo orderDetailsRepo;

    public List<OrderDetails> findAll(){
        return orderDetailsRepo.findAll();
    }

    public OrderDetails savedata(OrderDetails orderDetails){
        return orderDetailsRepo.save(orderDetails);
    }

    public void deleteById(Long id){
        orderDetailsRepo.deleteById(id);
    }
}
