package com.example.myhotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myhotel.models.entity.AddOnsFacilities;
import com.example.myhotel.models.repos.AddonsFacilitiesRepo;

@Service
public class AddonsFacilitiesService {

    @Autowired 
    AddonsFacilitiesRepo addonsFacilitiesRepo;

    public List<AddOnsFacilities> findAllData(){
        return addonsFacilitiesRepo.findAll();
    }

    public Optional<AddOnsFacilities> findById(Long id){
        return addonsFacilitiesRepo.findById(id);
    }

    public AddOnsFacilities saveData(AddOnsFacilities aOnsFacilities){
        return addonsFacilitiesRepo.save(aOnsFacilities);
    }

    public void removeOneById(Long id){
        addonsFacilitiesRepo.deleteById(id);
    }
}
