package com.example.myhotel.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myhotel.models.entity.OrderDetails;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Long> {
    
}
