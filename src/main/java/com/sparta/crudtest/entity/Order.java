package com.sparta.crudtest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name="orders")
@Getter
@Setter
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;   // 기본 키
    private Long productId;
    private String name;
    private Double price;
    private Integer stock;
    private String description;

    // getter/setter
}