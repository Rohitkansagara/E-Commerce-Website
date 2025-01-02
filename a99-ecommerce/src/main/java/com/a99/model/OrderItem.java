package com.a99.model;

import jakarta.persistence.*;
import lombok.Data;


import java.math.BigDecimal;

@Data
@Entity
public class OrderItem {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    private Integer quantity;

    private BigDecimal price;

    @ManyToOne
    private Order order;

}
