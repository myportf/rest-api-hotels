package com.example.myhotel.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name="m_contactpersontrans")
public @Data class ContanctPesonTrans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 10)
    private String title; //Mr. | Mrs.
    @Column(length = 60)
    private String name;
    private String nik;

    @ManyToOne
    private Orders orders;
}
