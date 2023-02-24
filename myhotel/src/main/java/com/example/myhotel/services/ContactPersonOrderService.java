package com.example.myhotel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myhotel.models.entity.ContanctPesonTrans;
import com.example.myhotel.models.repos.ContactPersonOrdersRepo;

@Service
public class ContactPersonOrderService {
    @Autowired
    ContactPersonOrdersRepo contactPersonOrdersRepo;

    public List<ContanctPesonTrans> findAll(){
        return contactPersonOrdersRepo.findAll();
    }

    public ContanctPesonTrans savedata(ContanctPesonTrans contanctPesonTrans){
        return contactPersonOrdersRepo.save(contanctPesonTrans);
    }

    public Optional<ContanctPesonTrans> findById(Long id){
        return contactPersonOrdersRepo.findById(id);
    }

    public void deleteById(Long id){
        contactPersonOrdersRepo.deleteById(id);
    }
}
