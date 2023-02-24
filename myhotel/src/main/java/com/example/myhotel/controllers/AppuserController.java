package com.example.myhotel.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myhotel.DTO.AppUserData;
import com.example.myhotel.DTO.ResponsData;
import com.example.myhotel.models.entity.AppUser;
import com.example.myhotel.services.AppUserService;

@RestController
@RequestMapping("/api/users")
public class AppuserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AppUserService appUserService; 

    @GetMapping
    public Iterable<AppUser> findAll(){
        return appUserService.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity <ResponsData<AppUser>> reqister(@RequestBody AppUserData userdata){
        ResponsData<AppUser> responsData = new ResponsData<>();
        AppUser appUser = modelMapper.map(userdata, AppUser.class);
        responsData.setPayload(appUserService.registeAppUser(appUser));
        responsData.setStatus(true);
        responsData.getMessage().add("Appuser Saved!");
        return ResponseEntity.ok(responsData);
    }
}
