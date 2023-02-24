package com.example.myhotel.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myhotel.models.entity.Payments;

public interface PaymentRepo extends JpaRepository<Payments, Long> {
    
}
