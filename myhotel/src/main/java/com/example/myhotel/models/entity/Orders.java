package com.example.myhotel.models.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Entity
@Table(name = "t_orders")
public @Data class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_no", nullable = false, updatable = false)
    private String orderno = UUID.randomUUID().toString();

    @Column(name = "order_date_time", nullable = false, updatable = false)
    @CreatedDate
    private Timestamp createdDate = java.sql.Timestamp.valueOf(LocalDateTime.now());

    @ManyToOne
    private AppUser appUser;

    // @ManyToOne
    // private ContanctPesonTrans contanctPesonTrans;

    //actual checkin
    private Timestamp checkin_date;
    private Timestamp checkout_date;

    private Double deposite;

    //plan reservation date
    private Date from_date;
    private Date until_date;

    private Boolean isextends;
    @Column(length = 250)
    private String note;

    @Column(length = 30)
    private String status;
    
}
