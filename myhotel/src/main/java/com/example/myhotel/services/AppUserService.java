package com.example.myhotel.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myhotel.models.entity.AppUser;
import com.example.myhotel.models.repos.AppUserRepo;


@Service
public class AppUserService {
    @Autowired
    private AppUserRepo appUserRepo;

    public Optional<AppUser> findById(Long id){
        return appUserRepo.findById(id);
    }

    public Optional<AppUser> findUserByEmail(String _email){
        return appUserRepo.findByEmail(_email);
    }

    public List<AppUser> findAll(){
        return appUserRepo.findAll();
    }

    public AppUser registeAppUser(AppUser user){
        boolean emailexists = appUserRepo.findByEmail(user.getEmail()).isPresent();
        if(emailexists){
            throw new RuntimeException(
                String.format("Email Already Exists '%s' ", user.getEmail())
            );
        }

        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(user.getPassword().getBytes(),0, user.getPassword().length());  
            String hashedPass = new BigInteger(1,messageDigest.digest()).toString(16);  
            if (hashedPass.length() < 32) {
                hashedPass = "0" + hashedPass; 
                }
            user.setPassword(hashedPass);
           
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
        return appUserRepo.save(user);
    }

}
