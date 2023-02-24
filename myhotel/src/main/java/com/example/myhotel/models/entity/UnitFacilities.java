package com.example.myhotel.models.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "m_unitfacilities" )
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id"
)
public @Data class UnitFacilities implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 60)
    private String name;
    @Column(length = 250)
    private String description;

    @ManyToOne
    private UnitFacilistiesCategory unitFacilistiesCategory;

    @ManyToMany(mappedBy = "unitFacilities")
    @JsonIgnoreProperties("unitFacilities")
    @EqualsAndHashCode.Exclude Set<RoomHotels> roomHotels ;
}
