package com.example.myhotel.models.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "t_order_details")
public @Data class OrderDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private OrderType orderType; //room | addons | adjustment

    private String name;
    private String description;

    private Double unit_price;
    
    private Double line_amount;
    private Double tax_percentage;
    private Double tax_amount;

    @ManyToOne
    private Orders orders;

}
