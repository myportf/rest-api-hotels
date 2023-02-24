package com.example.myhotel.models.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity @NoArgsConstructor @AllArgsConstructor
@Table(name = "m_rooms")
public @Data class RoomHotels implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String code;
    @Column(length = 60)
    private String name;
    @Column(length = 250)
    private String description;
    private int capacity;

    @ManyToMany
    @JoinTable (name = "m_unitfacilities_room",
        joinColumns = @JoinColumn(name = "m_room_id"),
        inverseJoinColumns = @JoinColumn(name = "m_unitfacilities_id")           
    )
    @JsonIgnoreProperties("roomHotels")
    private Set<UnitFacilities> unitFacilities;

    @ManyToOne
    private KindsRooms kindsRooms;

    @ManyToOne
    private Hotels hotels;

}
