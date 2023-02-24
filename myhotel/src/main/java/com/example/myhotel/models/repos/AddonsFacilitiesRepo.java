package com.example.myhotel.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myhotel.models.entity.AddOnsFacilities;

public interface AddonsFacilitiesRepo extends JpaRepository<AddOnsFacilities, Long> {
    
}
