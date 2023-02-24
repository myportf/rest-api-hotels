package com.example.myhotel.models.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "m_addonsfacilitiesprice")
public @Data class AddOnsFacilitiesPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="m_addonsFacilitiesprice_id")
    private Long id;
    private Double price;
    private Date valid_from;
    private Date valid_until;

    @ManyToOne
    private AddOnsFacilities addOnsFacilities;
}
