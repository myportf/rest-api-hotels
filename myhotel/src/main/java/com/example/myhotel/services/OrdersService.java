package com.example.myhotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myhotel.models.entity.Orders;
import com.example.myhotel.models.repos.OrdersRepo;

@Service
public class OrdersService {
    @Autowired
    OrdersRepo ordersRepo;

    public List<Orders> findAllOrder(){
        return ordersRepo.findAll();
    }

    public Orders findById(Long id){
        Optional<Orders> orders_ = ordersRepo.findById(id);
        if(!orders_.isPresent()){
            return null;
        }
        return ordersRepo.findById(id).get();
    }

    public Orders saveOrders(Orders orders){
        return ordersRepo.save(orders);
    }

    public void deleteOrderById(Long id){
        ordersRepo.deleteById(id);
    }
}
