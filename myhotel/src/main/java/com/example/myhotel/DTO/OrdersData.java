package com.example.myhotel.DTO;

import java.sql.Date;

import com.example.myhotel.models.entity.AppUser;

import lombok.Data;

public @Data class OrdersData {

    private AppUser appUser;
    private Double deposite;
    //reservation date
    private Date from_date;
    private Date until_date;
    private Boolean isextends;
    private String note;
    private String status;
}
