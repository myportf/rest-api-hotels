package com.example.myhotel.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myhotel.models.entity.ContanctPesonTrans;

public interface ContactPersonOrdersRepo extends JpaRepository<ContanctPesonTrans, Long> {
    
}
