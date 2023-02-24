package com.example.myhotel.models.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Entity
@Table(name = "t_bill_header")
public @Data class BillHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_no", nullable = false, updatable = false)
    private String orderno = UUID.randomUUID().toString();

    @Column(name = "bill_date_time", nullable = false, updatable = false)
    @CreatedDate
    private Timestamp createdDate = java.sql.Timestamp.valueOf(LocalDateTime.now());

    private Boolean isPayment;  
}
