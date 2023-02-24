package com.example.myhotel.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Table(name = "m_addonsfacilities")
public @Data class AddOnsFacilities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="m_addonsfacilitiesid")
    private Long id;
    @Column(length = 10)
    @NotEmpty(message = "Code is required")
    private String code; 
    @NotEmpty(message = "Code is required")
    @Column(length = 60)
    private String name;
}
