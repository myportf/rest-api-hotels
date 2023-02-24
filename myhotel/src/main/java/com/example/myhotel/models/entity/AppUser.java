package com.example.myhotel.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name = "m_user")
public @Data class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    
    @Column(name = "first_name", length = 30)
    private String firstname;
    private String last_name;
    @Column(name = "email", length = 60, unique = true)
    private String email;

    @Column(name = "password", length = 200,nullable = false)
    private String password;

    @Column(length = 10)
    private String title;

    @Column(length = 20)
    private String nik;

}
