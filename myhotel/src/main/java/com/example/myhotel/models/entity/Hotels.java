package com.example.myhotel.models.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor @AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name="m_hotels")
public @Data class Hotels implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60)
    @NotEmpty(message = "Name is required")
    private String name;
    @Column(length = 30, unique = true)
    @NotEmpty(message = "Code is required")
    private String code;
    @Column(length = 250)
    private String description;
    @Column(length = 500)
    @NotEmpty(message = "Address is required")
    private String address;
    @Column(length = 20)
    private String handphone_no;
    @Column(length = 20)
    private String telp_no;
    @Column(length = 60)
    private String email;
    @Column( length = 500)
    private String file_image;
    @Column(length = 500)
    private String file_path;

    @Column(length = 100)
    private String latitude ;
    @Column(length = 100)
    private String longitude;

    // @JsonManagedReference
    @ManyToMany
    @JoinTable (name = "m_hotel_accopolicies",
        joinColumns = @JoinColumn(name = "m_hotels_id"),
        inverseJoinColumns = @JoinColumn(name = "m_accomodationPolicies_id")           
    )
    @JsonIgnoreProperties("hotels")
    private Set<AccomodationPolicies> accomodationPolicies;

}
