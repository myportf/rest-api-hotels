package com.example.myhotel.models.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myhotel.models.entity.UnitFacilities;

public interface UnitFacilitiesRepo extends JpaRepository<UnitFacilities, Long> {
    
}
