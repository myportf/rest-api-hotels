package com.example.myhotel.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myhotel.models.entity.Orders;

public interface OrdersRepo extends JpaRepository<Orders, Long> {
    
}
