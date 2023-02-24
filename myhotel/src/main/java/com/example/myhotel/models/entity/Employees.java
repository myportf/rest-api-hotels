package com.example.myhotel.models.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "m_employee")
public @Data class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 60)
    private String name;
    @Column(length = 10)
    private String code;
    @Column(length = 30, unique = true)
    private String nik;
    @Column(length = 30, unique = true)
    private String email;
    @Column(length = 2)
    private String gender;
    @Column(length = 10)
    private String religion;
    private Date join_date;
    private Date regisn_date;
}
